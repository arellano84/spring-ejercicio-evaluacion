/**
 * 
 */
package app.negocio;

import app.modelo.Libro;

/**
 * @author arellano84
 * @version 20141122
 * 
 * Interface de negocio para ejecución desde el cliente.
 */
public interface ItfzGestionLibreria {

	/** Crea un nuevo registro en la tabla con los datos del libro recibido como argumento
	  * @param libro el objeto a insertar
	  * @return true si el alta se ha realizado, false caso contrario
	  * @throws Excepcion
	  */
	public void altaLibro(Libro libro)  throws Exception;
	
	/** Elimina el registro indicado en la tabla libro
	  * @param isbn del registro a eliminar
	  * @return true si se ha elimando correctamente, false caso contrario
	  */
	public void eliminarLibro(String ISBN);
	
	/** Consulta todos los registros de la tabla Libro
	  * @return List de Libro
	  */
	public void consultarTodos();
	
	/** Consulta el registro indicado de la tabla Libro
	  * @return isbn de registro a consultar
	  */
	public void consultarISBN(String isbn);
	
	/** Consulta el registro indicado de la tabla Libro
	  * @return titulo de registro a consultar
	  */
	public void consultarTitulo(String titulo);
	
	/** Modifica precio del registro indicado en la tabla libro
	  * @param isbn del registro a eliminar, precio que se modifica
	  * @return true si se ha modificado correctamente, false caso contrario
	  */
	public void modificarPrecio(String isbn, double precio);
	
}