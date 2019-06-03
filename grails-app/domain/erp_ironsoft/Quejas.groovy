package erp_ironsoft

class Quejas {

    String asunto
    String descripcion
    static hasMany = [archivos: Archivo]
    static belongsTo = [dependencia: Dependencia,dependenciaRespuesta: Dependencia, ubicacion: Ubicacion]

    Date fechaPublicacion
    Date fechaEstimadaAtencion


    static constraints = {
      asunto nullable:false
      descripcion nullable: false
      archivos nullable:true
      dependencia nullable:false
      dependenciaRespuesta nullable:true
      ubicacion nullable:false
      fechaPublicacion nullable:true
      fechaPublicacion nullable : true
    }
}
