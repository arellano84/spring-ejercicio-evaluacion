package app.utilidades;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author LuisJArellano
 * @version 20141122
 * 
 * Clase con el método que se ejecutará al interceptar otro a través de AOP. 
 */
@Aspect
@Component
public class Interceptor {
	
	@Pointcut("execution(* app.negocio.GestionLibreria.altaLibro(..))")
	public void altaLibro(){}
	
	/**  Este método muestra un mensaje en consola informando que el libro se ha insertado correctamente en la BBDD.
	  * @return void
	  */
	@AfterReturning("altaLibro()")
	public void interceptarAltaLibro(){
		
		System.out.println("AOP: El libro se ha insertado correctamente.");
	}
	
//	@AfterThrowing(throwing="ex", pointcut="altaLibro()")
//	public void interceptarAltaLibroError(){
//		
//		System.out.println("Error al insertar el libro.");
//	}
}
