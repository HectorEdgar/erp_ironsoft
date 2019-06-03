package erp_ironsoft

import grails.gorm.services.Service

@Service(SolicitudServicio)
interface SolicitudServicioService {

    SolicitudServicio get(Serializable id)

    List<SolicitudServicio> list(Map args)

    Long count()

    void delete(Serializable id)

    SolicitudServicio save(SolicitudServicio solicitudServicio)

}