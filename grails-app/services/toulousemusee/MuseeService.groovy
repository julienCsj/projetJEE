package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    def serviceMethod() {

    }

    def insertOrUpdateMusee(Musee musee, Gestionnaire gestionnaire, Adresse adresse) {
        adresse.save()
        gestionnaire.save()
        musee.gestionnaire = gestionnaire
        musee.adresse = adresse
        musee.save()
        musee
    }

    def deleteMusee(Musee m) {
        m.adresse.delete();
        m.delete()
    }
}
