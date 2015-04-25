package toulousemusee


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DemandeVisiteMuseeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static scope = "prototype"

    def demandeVisiteMuseeService
    def favorisService


    def getForm() {
        Musee musee = Musee.findById(params.int("id"))
        render(view: 'form', model: [musee: musee])
    }

    def doAjoutDemande() {
        Integer idMusee = params.int("idMusee")
        Date dateDebut = params.dateDebut
        Date dateFin = params.dateFin

        Integer nbPersonne = params.int("nbPersonnes")

        Musee m = Musee.findById(idMusee)
        DemandeVisite dv = new DemandeVisite(code: demandeVisiteMuseeService.genererCode(), dateDebutPeriode: dateDebut,
        dateFinPeriode: dateFin, nbPersonnes: nbPersonne, statut: DemandeVisite.Statut.EN_COURS)

        dv.validate()

        if (dv.hasErrors()) {
            def message = []
            if (dv.errors.hasFieldErrors("nbPersonnes")) {
                message << "Les visites sont limités a 6 personnes."
            }

            print dv.errors
            return render(view: 'form', model: [musee: m, dateDebut: dateDebut,
                                                dateFin: dateFin, nbPersonnes: nbPersonne,
                                                message : message])
        } else {
            def dvm = demandeVisiteMuseeService.ajouterDemandeVisiteMusee(m, dv)
            return render(view: 'success', model: [dvm: dvm])
        }
    }

    def getFormStatut() {
        return render(view: 'statut')
    }

    def postFormStatut() {
        def code = params.int("code");
    }
}
