package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite valide"() {

        given: "une demande de visite initialise correctement"
        DemandeVisite dv = new DemandeVisite(code: 12, dateDebutPeriode: new Date(12, 04, 2015),
                dateFinPeriode: new Date(15, 04, 2015), nbPersonnes: 5, statut: DemandeVisite.Statut.EN_COURS)

        expect: "la demande de visite est valide"
        dv.validate() == true

    }

    @Unroll
    void "test l'invalidite d'une demande de vusite non valide"() {

        given: "une demande de visite invalide"
        DemandeVisite dv = new DemandeVisite(code: 12, dateDebutPeriode: new Date(12, 04, 2015),
                dateFinPeriode: new Date(15, 04, 2015), nbPersonnes: 0, statut: DemandeVisite.Statut.REFUSE)

        expect: "la demande de visite est invalide"
        dv.validate() == false
    }
}
