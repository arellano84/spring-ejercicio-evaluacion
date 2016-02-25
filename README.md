# spring-ejercicio-evaluacion
Proyecto de Evaluación Modulo Spring


ENUNCIADO EJERCICIO EVALUACION

1.- Crear un proyecto Java llamado Libreria.

2.- Crear los siguientes paquetes:
	app.cliente
	app.modelo
	app.negocio
	app.persistencia

3.- En el paquete app.modelo crear la clase encapsulada Libro con las siguientes propiedades:
	String titulo
	String autor
	String editorial
	String isbn
	int publicacion
	double precio
	String descripcion

4.- Crear una excepción personalizada denominada LibroNoEncontradoException que utilizaremos en los métodos del DAO donde al localizar el libro este no exista en la BBDD.

5.- Crear la base de datos llamada LIBRERIA con usuario/password curso/curso. Es obligatorio utilizar estas credenciales para que se pueda corregir el ejercicio. A continuación crearemos una tabla LIBROS que tenga la siguiente estructura:
	TITULO varchar (50)
	AUTOR varchar (50)
	EDITORIAL varchar (50)
	ISBN varchar (20) (Primary Key)
	PUBLICACION integer
	PRECIO double
	DESCRIPCION varchar(200)

6.- En el paquete app.persistencia crear una interface llamada ItfzLibrosDao con los siguientes métodos:
	public boolean altaLibro(Libro libro)
	public boolean eliminarLibro(String ISBN)
	public List<Libro> consultarTodos()
	public Libro consultarISBN(String isbn)
	public List<Libro> consultarTitulo(String titulo)
	public boolean modificarPrecio(String isbn, double precio)

7.- En el mismo paquete app.persistencia crear la clase LibrosDAO que implemente la interface anterior. Utilizaremos Spring JDBC y Spring Transaction
	public boolean altaLibro(Libro libro); Debe crear un nuevo registro en la tabla con los datos del libro recibido como argumento.
	public boolean eliminarLibro(String ISBN); Debe eliminar el libro de la tabla que coincida con el isbn pasado como argumento.
	public List<Libro> consultarTodos(); Devuelve una lista con todos los libros de la tabla.
	public Libro consultarISBN(String isbn); Devuelve una instancia del Libro localizado por su isbn.
	public List<Libro> consultarTitulo(String titulo); El argumento titulo recibido en el método puede que no sea el nombre completo. Se trata de devolver una lista con todos los libros que contienen ese dato como parte de su titulo. Utilizar el operador LIKE.
	public boolean modificarPrecio(String isbn, double precio); El método recibe el isbn del libro a actualizar, así como el nuevo precio.

8.- En la capa app.negocio crear una interface ItfzGestionLibreria con los mismos métodos que la interface anterior.
	En el mismo paquete crear la clase GestionLibreria que implemente la interface anterior. Todos los métodos deben acceder a la capa de persistencia a través de la interface ItfzLibrosDAO.

10.- Utilizando AOP crear una clase llamada Interceptor en el paquete app.utilidades con un método llamado interceptarAltaLibro. Este método deberá mostrar un mensaje en consola informando que el libro se ha insertado correctamente en la BBDD.

11.- Desde la clase principal de la aplicación que debe estar en el paquete app.cliente hacer uso de todos los métodos declarados en la clase GestionLibreria mostrando los resultados obtenidos por consola utilizando Spring.
