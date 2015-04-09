package toulousemusee

import org.springframework.transaction.annotation.Transactional

@Transactional
class MuseeService {

    def serviceMethod() {

    }

    def insertOrUpdateMusee(Musee musee, Gestionnaire gestionnaire, Adresse adresse) {
        /*adresse.save(flush: true)
        gestionnaire.save(flush: true)
        musee.gestionnaire = gestionnaire
        musee.adresse = adresse*/
        musee.save(flush: true)
        musee
    }

    def deleteMusee(Musee m) {
        m.adresse.delete();
        m.delete()
    }
}
