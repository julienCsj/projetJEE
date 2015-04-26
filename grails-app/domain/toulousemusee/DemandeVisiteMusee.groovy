package toulousemusee

import java.sql.Timestamp

class DemandeVisiteMusee {

    Timestamp version
    Musee musee
    DemandeVisite demandeVisite
    Date dateDemande

    static mapping = {
        musee lazy: false
        demandeVisite lazy: false
    }

    static constraints = {
    }
}
