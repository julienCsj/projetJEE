package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"() {

        given: "une adresse initialise avec un numero de rue, une rue, un code postal et une ville"
        Adresse adresse = new Adresse(numero: "35", rue: "Henri de Sahuque", codePostal: 31400, ville: "Toulouse")

        expect: "l'adresse est valide"
        adresse.validate() == true

    }

    @Unroll
    void "test l'invalidite d'une adresse non valide"(String numero, String rue, int codePostal, String ville) {

        given: "une adresse invalide"
        Adresse adresse = new Adresse(numero: numero, rue: rue, codePostal: codePostal, ville: ville)

        expect: "l'adresse est invalide"
        adresse.validate() == false

        where:
        numero     | rue                  | codePostal    | ville
        "1"        | ""                   | 31400         | "Toulouse"
        "1"        | null                 | 31400         | "Toulouse"
        "1"        | "Henri de Sahuque"   | 31400         | ""
        "1"        | "Henri de Sahuque"   | 31400         | null
        ""         | "Henri de Sahuque"   | 31400         | "Toulouse"
        null       | "Henri de Sahuque"   | 31400         | "Toulouse"

    }
}
