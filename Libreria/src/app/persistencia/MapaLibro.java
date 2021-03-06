package app.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import app.modelo.Libro;

/**
 * @author arellano84
 * @version 20141122
 * 
 * Mapper para la consulta de los datos de la tabla Libro.
 */
@Component
public class MapaLibro implements RowMapper<Libro>{
	
	/**  Devuelve el objeto Libro a el RowMapper
	  * @return Libro
	  * @throws SQLException
	  */
	public Libro mapRow(ResultSet rs, int i) throws SQLException{
		Libro libro = new Libro();
		libro.setTitulo(rs.getString("titulo"));
		libro.setAutor(rs.getString("autor"));
		libro.setEditorial(rs.getString("editorial"));
		libro.setIsbn(rs.getString("isbn"));
		libro.setPublicacion(rs.getInt("publicacion"));
		libro.setPrecio(rs.getDouble("precio"));
		libro.setDescripcion(rs.getString("descripcion"));
		
		return libro;
	}
}
