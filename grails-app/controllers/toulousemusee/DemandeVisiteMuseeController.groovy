package toulousemusee


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DemandeVisiteMuseeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def demandeVisiteMuseeService = new DemandeVisiteMuseeService()

    def getForm() {
        print "idMusee = "+params.int("id")
        Musee musee = Musee.findById(params.int("id"))
        print "Le Musee : "+musee
        render(view: 'form', model: [musee: musee])
    }

    def doAjoutDemande() {
        Integer idMusee = params.int("idMusee")
        Date dateDebut = params.date("dateDebut", "dd-MM-yyyy")
        Date dateFin = params.date("dateFin", "dd-MM-yyyy")
        Integer nbPersonne = params.int("nbPersonnes")

        Musee m = Musee.findById(idMusee)
        DemandeVisite dv = new DemandeVisite(code: demandeVisiteMuseeService.genererCode(), dateDebutPeriode: dateDebut,
        dateFinPeriode: dateFin, nbPersonnes: nbPersonne, statut: "En attente ...")

        if(dv.hasErrors()) {
            return render(view: 'form', model: [musee: m, dateDebut: dateDebut,
                                         dateFin: dateFin, nbPersonnes: nbPersonne,
                                         errors : dv.getErrors()])
        } else {
            demandeVisiteMuseeService.ajouterDemandeVisiteMusee(m, dv)
        }

        return render(view: 'success', model: [musee: m, demandeVisite: dv])
    }
}
