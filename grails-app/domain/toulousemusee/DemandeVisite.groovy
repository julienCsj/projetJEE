package toulousemusee

class DemandeVisite {

    int code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    String statut

    static constraints = {
        nbPersonnes range: 1..6
    }
}
