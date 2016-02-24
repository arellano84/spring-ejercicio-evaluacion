package app.persistencia;

/**
 * @author LuisJArellano
 * @version 20141122
 * 
 * Excepción personalizada que se utiliza en los métodos del DAO donde al localizar el libro este no exista en la BBDD.
 */
public class LibroNoEncontradoException extends RuntimeException {//Del tipo RuntimeException para evitar poner throws
	LibroNoEncontradoException(String nombre) {
       super("No se encontro Libro-->"+nombre);//Se imprime mensaje en caso de generarse la excepción.
   }

}
