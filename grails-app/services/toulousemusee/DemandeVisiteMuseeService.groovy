package toulousemusee

import grails.transaction.Transactional

@Transactional
class DemandeVisiteMuseeService {

    def genererCode() {
        int minimum = 10000
        int maximum = 99999
        int randomNum = minimum + (int)(Math.random()*maximum);
        randomNum
    }

    def ajouterDemandeVisiteMusee(Musee m, DemandeVisite dv) {
        dv.save(flush: true)
        DemandeVisiteMusee dvm = new DemandeVisiteMusee(musee: m, demandeVisite: dv, date: new Date())
        dvm.save(flush: true)
        dvm
    }
}
