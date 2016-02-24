package app.cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.modelo.Libro;
import app.negocio.ItfzGestionLibreria;

/**
 * @author arellano84
 * @version 20141124
 * 
 * Modulo Spring - Ejercicio evaluación.
 */
public class Main{
	
	public static void main(String[] args){
		
		//Generando el contenedor de beans
		ApplicationContext contenedor = new ClassPathXmlApplicationContext("spring.xml");
		
		System.out.println("******************************LIBRERIA*****************************************");
		
		//Obtiene el bean gestionLibreria del nucleo. Se accederá a través de la interface.
		ItfzGestionLibreria igestionlibreria = (ItfzGestionLibreria) contenedor.getBean("gestionLibreria");
		
		//Se ejecutan todo los procesos.
		System.out.println("\n____________________________Alta Libro_________________________________________");
		try{
			igestionlibreria.altaLibro(new Libro("Hibernate","Juan","Anaya","12345",2010,260,"Persitencia"));
		}catch(Exception e){}
		System.out.println("\n____________________________Consultar Todos____________________________________");
		igestionlibreria.consultarTodos();
		
		System.out.println("\n____________________________Consultar X ISBN___________________________________");
		igestionlibreria.consultarISBN("12345");
		
		System.out.println("\n____________________________Consultar X Titulo_________________________________");
		igestionlibreria.consultarTitulo("Hiber");
		
		System.out.println("\n____________________________Modificar Precio___________________________________");
		igestionlibreria.modificarPrecio("12345", 250);
		
		System.out.println("\n____________________________Eliminar Libro_____________________________________");
		igestionlibreria.eliminarLibro("12345");
	}

}
