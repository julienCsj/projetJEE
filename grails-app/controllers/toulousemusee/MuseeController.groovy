package toulousemusee



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def museeService

    def getSearchForm() {
        def codePostalList = Adresse.list().unique { it.codePostal }
        print "Liste des codes : "+codePostalList
        render(view: 'index', model: [codePostalList: codePostalList])
    }

    def doSearchMusee(Integer max) {
        String nom = params.nom
        Integer cp = params.int("codePostal")
        String rue = params.rue

        def codePostalList = Adresse.list().unique { it.codePostal }
        params.max = Math.min(max ?: 5, 100)

        def museeList = museeService.searchMusees(nom, cp, rue)

        render(view: 'index', model: [museeInstanceList: museeList.drop(params.int('offset')?:0).take(params.int('max')),
                                      museeInstanceCount: museeList.size(),
                                      nom: nom, codePostal: cp, rue: rue,
                                      codePostalList: codePostalList, params: params])
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Musee.list(params), model:[museeInstanceCount: Musee.count()]
    }

    def show(Musee museeInstance) {
        respond museeInstance
    }

    def create() {
        respond new Musee(params)
    }

    @Transactional
    def save(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view:'create'
            return
        }

        museeService.insertOrUpdateMusee(museeInstance, museeInstance.gestionnaire, museeInstance.adresse)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*' { respond museeInstance, [status: CREATED] }
        }
    }

    def edit(Musee museeInstance) {
        respond museeInstance
    }

    @Transactional
    def update(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view:'edit'
            return
        }

        museeService.insertOrUpdateMusee(museeInstance, museeInstance.gestionnaire, museeInstance.adresse)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*'{ respond museeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Musee museeInstance) {

        if (museeInstance == null) {
            notFound()
            return
        }

        museeService.deleteMusee(museeInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musee.label', default: 'Musee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
