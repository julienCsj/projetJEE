package toulousemusee

import org.springframework.transaction.annotation.Transactional

@Transactional
class MuseeService {

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

    List<Musee> searchMusees(String nom, Integer codePostal, String rue) {
        def criteria = Musee.createCriteria()


        List<Musee> res = criteria.list () {
            if (nom) {
                like 'nom', "%${nom}%"
            }
            if (codePostal) {
                adresse {
                    eq 'codePostal', codePostal
                }
            }
            if (rue) {
                adresse {
                    like 'rue', "%${rue}%"
                }
            }
            join 'adresse'
            join 'gestionnaire'
            order('nom')
        }
        res
    }
}
