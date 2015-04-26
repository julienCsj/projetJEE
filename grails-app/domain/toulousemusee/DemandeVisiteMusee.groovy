package toulousemusee

class DemandeVisiteMusee {

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
