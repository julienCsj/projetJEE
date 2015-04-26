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
        def favorisList = favorisService.listeFavoris
        render(view: 'form', model: [musee: musee, favorisList: favorisList])
    }

    def doAjoutDemande() {

        Integer idMusee = params.int("idMusee")
        Date dateDebut = params.dateDebut
        Date dateFin = params.dateFin

        Integer nbPersonne = params.int("nbPersonnes")

        Musee m = Musee.findById(idMusee)
        DemandeVisite dv = new DemandeVisite(code: demandeVisiteMuseeService.genererCode(), dateDebutPeriode: dateDebut,
        dateFinPeriode: dateFin, nbPersonnes: nbPersonne, statut: DemandeVisite.Statut.EN_COURS)

        def favorisList = favorisService.listeFavoris

        dv.validate()

        if (dv.hasErrors()) {
            def message = []
            if (dv.errors.hasFieldErrors("nbPersonnes")) {
                message << "Les visites sont limités a 6 personnes."
            }

            return render(view: 'form', model: [musee: m, dateDebut: dateDebut,
                                                dateFin: dateFin, nbPersonnes: nbPersonne,
                                                message : message, favorisList: favorisList
                    ])
        } else {
            def dvm = demandeVisiteMuseeService.ajouterDemandeVisiteMusee(m, dv)
            return render(view: 'success', model: [dvm: dvm, favorisList: favorisList])
        }
    }

    def getFormStatut() {
        def favorisList = favorisService.listeFavoris
        return render(view: 'statut', model: [favorisList: favorisList])
    }

    def postFormStatut() {
        def favorisList = favorisService.listeFavoris
        Integer code = params.int("code");

        def listDemande = demandeVisiteMuseeService.getDemandeVisiteMusee(code)
        if(listDemande.size() != 1 || !code) {
            return render(view: 'statut', model: [message: ["Ce code ne correspond a aucune demande ..."], favorisList: favorisList])
        } else {
            return render(view: 'infosDemande', model: [dvm: listDemande.get(0), favorisList: favorisList])
        }

    }
}
