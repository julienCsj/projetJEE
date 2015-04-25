package toulousemusee

class DemandeVisite {

    int code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    Statut statut

    static constraints = {
        nbPersonnes range: 1..6
    }

    enum Statut {
        EN_COURS, CONFIRME, REFUSE
    }
}
