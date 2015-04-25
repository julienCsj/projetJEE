package toulousemusee

class DemandeVisiteMusee {

    Musee musee
    DemandeVisite demandeVisite
    Date dateDemande

    static constraints = {
    }


    @Override
    public String toString() {
        return "DemandeVisiteMusee{" +
                "id=" + id +
                ", musee=" + musee +
                ", demandeVisite=" + demandeVisite +
                ", dateDemande=" + dateDemande +
                ", version=" + version +
                '}';
    }
}
