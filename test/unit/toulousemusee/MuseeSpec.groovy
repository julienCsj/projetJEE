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
    void "test la validite d'un musee valide"(String unNom, String unHoraire, String unTelephone, String unAccesMetro, String unAccesBus) {

        given: "un musee initialise avec des valeurs non nulles et non vides"
        Musee musee = new Musee(nom: unNom, horairesOuverture: unHoraire, telephone: unTelephone, accesMetro: unAccesMetro, accesBus: unAccesBus, adresse: Mock(Adresse), gestionnaire: Mock(Gestionnaire))

        expect: "le musee est valide"
        musee.validate() == true

        where:
        unNom                 | unHoraire                                               | unTelephone      | unAccesMetro  | unAccesBus
        "Musée des Abattoirs" | "Ouvert de 8h à 22h30"                                  | "0561675432"     | null      | "2, 4"
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | "05 61 55 54 32" | "Les 3 cocus" | "8, 6"
    }

    @Unroll
    void "test l'invalidite d'un musee invalide"(String unNom, String unHoraire, String unTelephone, String unAccesMetro, String unAccesBus, Adresse uneAdresse, Gestionnaire unGestionnaire) {

        given: ""
        Musee musee = new Musee(nom: unNom, horairesOuverture: unHoraire, telephone: unTelephone, accesMetro: unAccesMetro, accesBus: unAccesBus)

        expect: "le musee est valide"
        musee.validate() == false

        where:
        unNom                 | unHoraire                                               | unTelephone        | unAccesMetro | unAccesBus | uneAdresse    | unGestionnaire
        null                  | "Ouvert de 8h à 22h30"                                  | "0561675432"       | "Carmes"     | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // Nom null
        ""                    | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | "05 61 55 54 32"   | "Carmes"     | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // Nom blank
        "Musée des Abattoirs" | null                                                    | "0561675432"       | "Carmes"     | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // horaire null
        "Musée du Quai Brany" | ""                                                      | "05 61 55 54 32"   | "Carmes"     | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // horaire blank
        "Musée des Abattoirs" | "Ouvert de 8h à 22h30"                                  | "0561675432552425" | "Carmes"     | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // telephone long
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | null               | "Carmes"     | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // telephone null
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | ""                 | "Carmes"     | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // telephone blank
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | "0561675432"       | "Carmes"     | "8, 6"     | Mock(Adresse) | null               // gest null
        "Musée du Quai Brany" | "7h à 22h30 en été. Fermé en Hiver pour cause de froid" | "0561675432"       | "Carmes"     | "8, 6"     | null          | Mock(Gestionnaire) // adresse null
        "Musée des Abattoirs" | "Ouvert de 8h à 22h30"                                  | "0561675432"       | ""           | "8, 6"     | Mock(Adresse) | Mock(Gestionnaire) // metro blank
        "Musée des Abattoirs" | "Ouvert de 8h à 22h30"                                  | "0561675432"       | "Carmes"     | null       | Mock(Adresse) | Mock(Gestionnaire) // bus null
        "Musée des Abattoirs" | "Ouvert de 8h à 22h30"                                  | "0561675432"       | "Carmes"     | ""         | Mock(Adresse) | Mock(Gestionnaire) // bus blank

    }


}
