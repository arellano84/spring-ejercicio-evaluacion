package app.persistencia;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.modelo.Libro;

/**
 * @author arellano84
 * @version 20141122
 * 
 * Bean de ejecución del DAO que tendra acceso desde la interface del DAO.
 */
//Declaración del bean con anotaciones.
@Component
public class LibrosDAO implements ItfzLibrosDao{//Implementando la interface ItfzLibrosDao.
	
	//Inyectando objeto al bean con anotaciones.
	@Inject
	private NamedParameterJdbcTemplate plantilla;
	//Inyectando objeto al bean con anotaciones.
	@Inject
	private RowMapper<Libro> mapalibro;
	
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public boolean altaLibro(Libro libro){
		
		Map<String,Object> parametros= new HashMap<String, Object>();
		parametros.put("titulo", libro.getTitulo());
		parametros.put("autor", libro.getAutor());
		parametros.put("editorial", libro.getEditorial());
		parametros.put("isbn", libro.getIsbn());
		parametros.put("publicacion", libro.getPublicacion());
		parametros.put("precio", libro.getPrecio());
		parametros.put("descripcion", libro.getDescripcion());
		
		String querysql="insert into libros values (:titulo,:autor,:editorial,:isbn,:publicacion,:precio,:descripcion)";
		int insertado = plantilla.update(querysql, parametros);
		
		return insertado>0?true:false;
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public boolean eliminarLibro(String isbn){
		
		Map<String,Object> parametros= new HashMap<String, Object>();
		parametros.put("isbn", isbn);
		String querysql="delete from libros where isbn=:isbn";
		int eliminado = plantilla.update(querysql, parametros);
		
		return eliminado>0?true:false;
	}
	
	public List<Libro> consultarTodos(){
		String querysql="select * from libros";
		List<Libro> libros= plantilla.query(querysql, (Map<String,Object>)null, mapalibro); 
		if(libros.size()>0)
			return libros;
		else
			throw new LibroNoEncontradoException("Is Empty");
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public Libro consultarISBN(String isbn){
		try{
			String querysql="select * from libros where isbn=:isbn";
			Map<String,Object> parametros = new HashMap<String,Object>();
			parametros.put("isbn", isbn);			
			return plantilla.queryForObject(querysql, parametros, mapalibro);
		}catch(EmptyResultDataAccessException e){
			throw new LibroNoEncontradoException("isbn="+isbn);
		}
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public List<Libro> consultarTitulo(String titulo){
		String querysql="select * from libros where titulo like CONCAT('%',:titulo,'%')";
		Map<String,Object> parametros = new HashMap<String,Object>();
		parametros.put("titulo", titulo);
		List<Libro> libros= plantilla.query(querysql, parametros, mapalibro);
		if(libros.size()>0)
			return libros;
		else
			throw new LibroNoEncontradoException("titulo="+titulo);
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public boolean modificarPrecio(String isbn, double precio){
		
		Map<String,Object> parametros= new HashMap<String, Object>();
		parametros.put("isbn", isbn);
		parametros.put("precio", precio);
		String querysql="update libros set precio=:precio where isbn=:isbn";
		int modificado= plantilla.update(querysql, parametros);
		
		return modificado>0?true:false;
	}
	
	public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}

	public RowMapper<Libro> getMapalibro() {
		return mapalibro;
	}

	public void setMapalibro(RowMapper<Libro> mapalibro) {
		this.mapalibro = mapalibro;
	}
	
}
