class Libro {

    var titulo: String = ""
    var autor: String = ""
    var isbm:Int = 0
    var noPaginas:Int = 0
    var precio: Int = 0
    var cantidadDisponible: Int = 0
    var prestarLibro: Boolean = false

    constructor()
    constructor(
        titulo: String,
        autor: String,
        isbm: Int,
        noPaginas: Int,
        precio: Int,
        cantidadDisponible: Int,
        prestarLibro: Boolean = false
    ) {
        this.titulo = titulo
        this.autor = autor
        this.isbm = isbm
        this.noPaginas = noPaginas
        this.precio = precio
        this.cantidadDisponible = cantidadDisponible
        this.prestarLibro = prestarLibro
    }

    fun prestarLibro(): Boolean{
        if (cantidadDisponible > 0){
            cantidadDisponible--
            prestarLibro = true
            return true
        } else{
            return false
        }
    }
    fun devolverLibro(): Boolean{
        if (prestarLibro){
            cantidadDisponible++
            prestarLibro = false
            return true
        } else {
            return false
        }
    }
    fun infoLibro(){
        println("Titulo: $titulo")
        println("Autor: $autor")
        println("isbm: $isbm")
        println("Numero de paginas: $noPaginas")
        println("Precio: $precio")
        println("cantidad disponible: $cantidadDisponible")

    }


}