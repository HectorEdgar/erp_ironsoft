package erp_ironsoft

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class QuejasServiceSpec extends Specification {

    QuejasService quejasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Quejas(...).save(flush: true, failOnError: true)
        //new Quejas(...).save(flush: true, failOnError: true)
        //Quejas quejas = new Quejas(...).save(flush: true, failOnError: true)
        //new Quejas(...).save(flush: true, failOnError: true)
        //new Quejas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //quejas.id
    }

    void "test get"() {
        setupData()

        expect:
        quejasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Quejas> quejasList = quejasService.list(max: 2, offset: 2)

        then:
        quejasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        quejasService.count() == 5
    }

    void "test delete"() {
        Long quejasId = setupData()

        expect:
        quejasService.count() == 5

        when:
        quejasService.delete(quejasId)
        sessionFactory.currentSession.flush()

        then:
        quejasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Quejas quejas = new Quejas()
        quejasService.save(quejas)

        then:
        quejas.id != null
    }
}
