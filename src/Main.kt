import javax.xml.transform.Source

fun main() {

    val libros = mutableListOf(
        Libro(
        titulo = "Don Quijote",
        autor = "Miguel de Cervantes",
        isbm = 88561,
        noPaginas = 1342,
        precio = 98000,
        cantidadDisponible = 5
        ),
        Libro(
            titulo = "It",
            autor = "Stephen King",
            isbm = 88562,
            noPaginas = 1504,
            precio = 62300,
            cantidadDisponible = 9
        ),
        Libro(
            titulo = "La odisea",
            autor = "Homero",
            isbm = 88563,
            noPaginas = 312,
            precio = 84999,
            cantidadDisponible = 15
        )
    )

    while (true){
        println("Prestamo de libros")
        println("1. Mostrar los libros disponibles ")
        println("2. Prestar libro")
        println("3. Devolver libro")
        println("4. Salir")


        println("Escoja una opcion: ")

        when (readln()?.toIntOrNull()){
            1 -> {
                println("Lista de libros")
                libros.forEachIndexed { index, libro ->
                    println("Libro ${index + 1}:")
                    libro.infoLibro()
                }
            }
            2 -> {
                println("Ingrese el ISBN del libro que va alquilar: ")
                val isbnPrestamo = readln()?.toIntOrNull()

                if (isbnPrestamo != null) {
                    val libroEncontrado = libros.find { Libro -> Libro.isbm == isbnPrestamo }
                    if (libroEncontrado != null){
                        if (libroEncontrado.prestarLibro()){
                            println("Libro '${libroEncontrado.titulo}' se ha prestado correctamente")
                        } else {
                            println("No hay libros disponibles de este titulo. ")
                        }
                    } else {
                        println("No se encontro el libro con el ISBN: $isbnPrestamo")
                    }
                } else {
                    println("ISBN invalido, debe ser un numero")
                }

            }
            3 -> {
                println("Ingrese el ISBN que va a devolver: ")
                val isbnDevolucion = readln()?.toIntOrNull()

                if (isbnDevolucion != null) {
                    val libroEncontrado = libros.find { Libro -> Libro.isbm == isbnDevolucion }

                    if (libroEncontrado != null) {
                        if (libroEncontrado.devolverLibro()) {
                            println("Libro '${libroEncontrado}' fue devuelto correctamente")
                        } else {
                            println("No se pudo devolver el libro. Asegurese que el ISBN sea correcto ")
                        }
                    } else {
                        println("ISBN invalido, debe ser un numero")
                    }
                }
            }

            4 -> {
                println("Saliendo al menú...")
                break
            }
        }
        }
}