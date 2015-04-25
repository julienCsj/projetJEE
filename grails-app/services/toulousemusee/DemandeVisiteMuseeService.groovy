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
        DemandeVisiteMusee dvm = new DemandeVisiteMusee(musee: m, demandeVisite: dv, date: new Date())
        if(dvm.hasErrors()) {
            print "ERREUR !!!!!!!!!!!!!!!!!"
        } else {
            dvm.save(flush: true)
        }
    }
}
