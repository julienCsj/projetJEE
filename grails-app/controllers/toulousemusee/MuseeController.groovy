package toulousemusee



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    static scope = "prototype"

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def museeService
    def favorisService

    // RECHERCHE DE MUSEES
    def getSearchForm() {
        def codePostalList = Adresse.list().unique { it.codePostal }
        def favorisList = favorisService.listeFavoris

        print "Liste des codes : "+codePostalList
        render(view: 'index', model: [codePostalList: codePostalList, favorisList: favorisList, index: "1"])
    }

    def doSearchMusee(Integer max) {
        String nom = params.nom
        Integer cp = params.int("codePostal")
        String rue = params.rue

        def favorisList = favorisService.listeFavoris
        def codePostalList = Adresse.list().unique { it.codePostal }
        params.max = Math.min(max ?: 5, 100)

        def museeList = museeService.searchMusees(nom, cp, rue)

        render(view: 'index', model: [museeInstanceList: museeList.drop(params.int('offset')?:0).take(params.int('max')),
                                      museeInstanceCount: museeList.size(),
                                      nom: nom, codePostal: cp, rue: rue,
                                      codePostalList: codePostalList, favorisList: favorisList, params: params])
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

    // GESTION DES FAVORIS
    def ajouterFavoris = {
        favorisService.ajouterAuxFavoris(params.telephone)

        String nom = params.nom
        String codePostal = params.codePostal
        String rue = params.rue
        if (codePostal.equals(""))
            codePostal = "null";

        redirect(action: "doSearchMusee", params: [nom: nom, codePostal: codePostal, rue: rue])
    }

    def supprimerFavoris = {
        favorisService.retirerDesFavoris(params.telephone)

        if(params.index.equals("1")) {
            redirect(action: "getSearchForm")
        } else {

            String nom = params.nom
            String codePostal = params.codePostal
            String rue = params.rue
            if (codePostal.equals(""))
                codePostal = "null";

            redirect(action: "doSearchMusee", params: [nom: nom, codePostal: codePostal, rue: rue])
        }
    }
}
