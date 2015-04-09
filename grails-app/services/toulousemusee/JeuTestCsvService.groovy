package toulousemusee

import grails.transaction.Transactional

@Transactional
class JeuTestCsvService {

    /*def parseCsv() {
        def csv = new File("grails-app/conf/Musee.csv")
        def musee
        csv.splitEachLine(';') { row ->
            musee = Musee.findByNom(row[0]) ?: new Musee(
                    nom: row[0],
                    horairesOuverture: row[],
                    telephone: row[],
                    accesMetro: row[],
                    accesBus: row[],
                    adresse: row[],
                    gestionnaire: row[1]
            ).save(failOnError: true, flush: true)
        }
    }*/
}
