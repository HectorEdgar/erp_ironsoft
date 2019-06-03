package erp_ironsoft

class Municipio {

    String nombre
    String capital
    String ubicacion
    String descripcion

    static hasMany = [comentario: Comentario]

    static constraints = {
    }
}
