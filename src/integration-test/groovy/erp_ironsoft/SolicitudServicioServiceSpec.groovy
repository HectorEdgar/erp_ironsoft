package erp_ironsoft

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SolicitudServicioServiceSpec extends Specification {

    SolicitudServicioService solicitudServicioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SolicitudServicio(...).save(flush: true, failOnError: true)
        //new SolicitudServicio(...).save(flush: true, failOnError: true)
        //SolicitudServicio solicitudServicio = new SolicitudServicio(...).save(flush: true, failOnError: true)
        //new SolicitudServicio(...).save(flush: true, failOnError: true)
        //new SolicitudServicio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //solicitudServicio.id
    }

    void "test get"() {
        setupData()

        expect:
        solicitudServicioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SolicitudServicio> solicitudServicioList = solicitudServicioService.list(max: 2, offset: 2)

        then:
        solicitudServicioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        solicitudServicioService.count() == 5
    }

    void "test delete"() {
        Long solicitudServicioId = setupData()

        expect:
        solicitudServicioService.count() == 5

        when:
        solicitudServicioService.delete(solicitudServicioId)
        sessionFactory.currentSession.flush()

        then:
        solicitudServicioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SolicitudServicio solicitudServicio = new SolicitudServicio()
        solicitudServicioService.save(solicitudServicio)

        then:
        solicitudServicio.id != null
    }
}
