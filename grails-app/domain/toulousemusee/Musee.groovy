package toulousemusee

class Musee {

    String nom
    String horairesOuverture
    String telephone
    boolean accesMetro
    boolean accesBus

    Adresse adresse
    Gestionnaire gestionnaire

    static constraints = {
       telephone size: 10..14, blank: false
    }
}
