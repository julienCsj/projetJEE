package toulousemusee

import grails.transaction.Transactional

@Transactional
class JeuTestCsvService {

    MuseeService museeService

    def parseCsv() {
        def csv = new File("grails-app/conf/Musee.csv")
        def gestionnaire
        def adresse
        def musee
        csv.splitEachLine(';') { row ->
            if (row[0] != "EQ_NOM_EQUIPEMENT") {
                gestionnaire = Gestionnaire.findByNom(row[1]) ?: new Gestionnaire(nom: row[1])

                adresse = new Adresse(numero: row[7], rue: row[8], codePostal: row[9], ville: row[10])
                adresse = Adresse.find(adresse) ?: adresse

                musee = Musee.findByNom(row[0]) ?: new Musee(
                        nom: row[0],
                        horairesOuverture: row[2],
                        telephone: row[4],
                        accesMetro: row[5],
                        accesBus: row[6])

                museeService.insertOrUpdateMusee(musee, gestionnaire, adresse)
            }
        }
    }
}
