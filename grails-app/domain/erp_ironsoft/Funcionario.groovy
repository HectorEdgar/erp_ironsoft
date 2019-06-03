package erp_ironsoft

class Funcionario {

    String puesto


    static  belongsTo = [dependencia: Dependencia, usuario: Usuario]
    static  hasMany = [comentario: Comentario]

    static constraints = {
    }
}
