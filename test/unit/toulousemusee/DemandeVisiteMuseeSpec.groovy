package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite de musée valide"() {

        given: "une demande de visite de musée initialise correctement"
        DemandeVisiteMusee dvm = new DemandeVisiteMusee(musee: Mock(Musee), demandeVisite: Mock(DemandeVisite),
                dateDemande: new Date(15, 04, 2015))

        expect: "la demande de visite de musée est valide"
        dvm.validate() == true

    }

    @Unroll
    void "test l'invalidite d'une demande de visite de musée non valide"(Musee unMusee, DemandeVisite uneDemande, Date uneDate) {

        given: "une demande de visite de musée invalide"
        DemandeVisiteMusee dvm = new DemandeVisiteMusee(musee: unMusee, demandeVisite: uneDemande, dateDemande: uneDate)

        expect: "la demande de visite de musée est invalide"
        dvm.validate() == false

        where:
        unMusee     | uneDemande          | uneDate
        null        | Mock(DemandeVisite) | new Date()
        Mock(Musee) | null                | new Date()
        Mock(Musee) | Mock(DemandeVisite) | null
    }
}
