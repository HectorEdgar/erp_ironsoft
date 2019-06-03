package erp_ironsoft

class SolicitudServicio {

    static belongsTo = [ubicacion: Ubicacion, dependencia : Dependencia,dependenciaRespuesta : Dependencia, usaurio: Usuario]
    static hasMany = [comentarios: Comentario]
    Date fechaEstimadaAtencion
    Date fechaPublicacion


    static constraints = {

    }
}
