package erp_ironsoft

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_SUPERADMIN','ROLE_ADMIN'])

class QuejasController {

    QuejasService quejasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond quejasService.list(params), model:[quejasCount: quejasService.count()]
    }

    def show(Long id) {
        respond quejasService.get(id)
    }

    def create() {
        respond new Quejas(params)
    }

    def save(Quejas quejas) {
        if (quejas == null) {
            notFound()
            return
        }

        try {
            quejasService.save(quejas)
        } catch (ValidationException e) {
            respond quejas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'quejas.label', default: 'Quejas'), quejas.id])
                redirect quejas
            }
            '*' { respond quejas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond quejasService.get(id)
    }

    def update(Quejas quejas) {
        if (quejas == null) {
            notFound()
            return
        }

        try {
            quejasService.save(quejas)
        } catch (ValidationException e) {
            respond quejas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'quejas.label', default: 'Quejas'), quejas.id])
                redirect quejas
            }
            '*'{ respond quejas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        quejasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'quejas.label', default: 'Quejas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'quejas.label', default: 'Quejas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
