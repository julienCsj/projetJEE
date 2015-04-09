package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musee valide"(String unNom, String unHoraire, String unTelephone, boolean unAccesMetro, boolean unAccesBus) {

        given: "un musee initialise avec des valeurs non nulles et non vides"
        Musee musee = new Musee(nom: unNom, horairesOuverture: unHoraire, telephone: unTelephone, accesMetro: unAccesMetro, accesBus: unAccesBus, adresse: Mock(Adresse), gestionnaire: Mock(Gestionnaire))

        expect: "le musee est valide"
        musee.validate() == true

        where:
        unNom                 | unHoraire                                               | unTelephone      | unAccesMetro | unAccesBus
        "Musée des Abattoirs" | "Ouvert de 8h à 22h30"                                  | "0561675432"     | true         | false
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | "05 61 55 54 32" | false        | true
    }

    @Unroll
    void "test l'invalidite d'un musee invalide"(String unNom, String unHoraire, String unTelephone, boolean unAccesMetro, boolean unAccesBus, Adresse uneAdresse, Gestionnaire unGestionnaire) {

        given: ""
        Musee musee = new Musee(nom: unNom, horairesOuverture: unHoraire, telephone: unTelephone, accesMetro: unAccesMetro, accesBus: unAccesBus)

        expect: "le musee est valide"
        musee.validate() == false

        where:
        unNom                 | unHoraire                                               | unTelephone        | unAccesMetro | unAccesBus | uneAdresse    | unGestionnaire
        null                  | "Ouvert de 8h à 22h30"                                  | "0561675432"       | true         | false      | Mock(Adresse) | Mock(Gestionnaire)
        ""                    | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | "05 61 55 54 32"   | false        | true       | Mock(Adresse) | Mock(Gestionnaire)
        "Musée des Abattoirs" | null                                                    | "0561675432"       | true         | false      | Mock(Adresse) | Mock(Gestionnaire)
        "Musée du Quai Brany" | ""                                                      | "05 61 55 54 32"   | false        | true       | Mock(Adresse) | Mock(Gestionnaire)
        "Musée des Abattoirs" | "Ouvert de 8h à 22h30"                                  | "0561675432552425" | true         | false      | Mock(Adresse) | Mock(Gestionnaire)
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | null               | false        | true       | Mock(Adresse) | Mock(Gestionnaire)
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | ""                 | false        | true       | Mock(Adresse) | Mock(Gestionnaire)
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | ""                 | false        | true       | Mock(Adresse) | null
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | "0561675432"       | false        | true       | null          | Mock(Gestionnaire)

    }


}
