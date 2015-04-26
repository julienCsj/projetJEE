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
        dv.save(flush: true, failOnError: true)
        DemandeVisiteMusee dvm = new DemandeVisiteMusee(musee: m, demandeVisite: dv, dateDemande: new Date())
        dvm.save(flush: true, failOnError: true)
        dvm
    }

    def getDemandeVisiteMusee(Integer code) {
        if(!code) {
            return []
        } else {

            def c = DemandeVisiteMusee.createCriteria()
            def results = c.list {
                demandeVisite {
                    eq("code", code.intValue())
                }
                join 'demandevisite'
                join 'musee'
            }
            results
        }
    }
}
