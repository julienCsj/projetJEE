package toulousemusee

import java.sql.Timestamp

class Musee {

    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus

    Adresse adresse
    Gestionnaire gestionnaire

    static mapping = {
        adresse lazy: false
        gestionnaire lazy: false
    }

    static constraints = {
        telephone size: 10..14
        accesMetro nullable: true
    }
}
