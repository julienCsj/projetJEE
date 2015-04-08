package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    @Unroll
    void "test la validite d'un gestionnaire valide"() {

        given: "un gestionnaire initialise avec un nom"
        Gestionnaire ges = new Gestionnaire(nom: "Julien")

        expect: "le gestionnaire est valide"
        ges.validate() == true

    }

    @Unroll
    void "test l'invalidite d'un gestionnaire non valide"() {

        given: "un gestionnaire invalide"
        Gestionnaire ges = new Gestionnaire(nom: "")

        expect: "le gestionnaire est invalide"
        ges.validate() == false
    }
}
