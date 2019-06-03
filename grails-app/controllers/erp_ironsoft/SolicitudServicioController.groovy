package erp_ironsoft

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SolicitudServicioController {

    SolicitudServicioService solicitudServicioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond solicitudServicioService.list(params), model:[solicitudServicioCount: solicitudServicioService.count()]
    }

    def show(Long id) {
        respond solicitudServicioService.get(id)
    }

    def create() {
        respond new SolicitudServicio(params)
    }

    def save(SolicitudServicio solicitudServicio) {
        if (solicitudServicio == null) {
            notFound()
            return
        }

        try {
            solicitudServicioService.save(solicitudServicio)
        } catch (ValidationException e) {
            respond solicitudServicio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'solicitudServicio.label', default: 'SolicitudServicio'), solicitudServicio.id])
                redirect solicitudServicio
            }
            '*' { respond solicitudServicio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond solicitudServicioService.get(id)
    }

    def update(SolicitudServicio solicitudServicio) {
        if (solicitudServicio == null) {
            notFound()
            return
        }

        try {
            solicitudServicioService.save(solicitudServicio)
        } catch (ValidationException e) {
            respond solicitudServicio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'solicitudServicio.label', default: 'SolicitudServicio'), solicitudServicio.id])
                redirect solicitudServicio
            }
            '*'{ respond solicitudServicio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        solicitudServicioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'solicitudServicio.label', default: 'SolicitudServicio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitudServicio.label', default: 'SolicitudServicio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
