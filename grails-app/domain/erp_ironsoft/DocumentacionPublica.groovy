package erp_ironsoft

class DocumentacionPublica {


    Date fechaCreacion
    String titulo
    String descripcion
    Municipio municipio
    static hasMany = [archivos: Archivo, comentarios: Comentario]
    static  belongsTo = [funcionario: Funcionario]
    String imagen



    static constraints = {
    }
}
