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

    @Override
    public String toString() {
        return "DemandeVisite{" +
                "id=" + id +
                ", code=" + code +
                ", dateDebutPeriode=" + dateDebutPeriode +
                ", dateFinPeriode=" + dateFinPeriode +
                ", nbPersonnes=" + nbPersonnes +
                ", statut=" + statut +
                ", version=" + version +
                '}';
    }

    enum Statut {
        EN_COURS, CONFIRME, REFUSE
    }


}
