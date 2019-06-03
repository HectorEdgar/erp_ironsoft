package erp_ironsoft

import grails.gorm.services.Service

@Service(Quejas)
interface QuejasService {

    Quejas get(Serializable id)

    List<Quejas> list(Map args)

    Long count()

    void delete(Serializable id)

    Quejas save(Quejas quejas)

}