package toulousemusee

class Musee {

    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus

    Adresse adresse
    Gestionnaire gestionnaire

    static constraints = {
        telephone size: 10..14
        accesMetro nullable: true
    }


    @Override
    public String toString() {
        return "Musee{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", horairesOuverture='" + horairesOuverture + '\'' +
                ", telephone='" + telephone + '\'' +
                ", accesMetro='" + accesMetro + '\'' +
                ", accesBus='" + accesBus + '\'' +
                ", adresse=" + adresse +
                ", gestionnaire=" + gestionnaire +
                ", version=" + version +
                '}';
    }
}
