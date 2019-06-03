package erp_ironsoft

class Comentario {

    static belongsTo = [usuario: Usuario]
    String comentario
    Date fecha

    static hasMany = [comentario: Comentario]


    static constraints = {
    }
}
