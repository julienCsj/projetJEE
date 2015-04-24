package toulousemusee

class Adresse {

    String numero
    String rue
    Integer codePostal
    String ville

    static constraints = {

    }

    @Override
    public String toString() {
        return "$numero $rue $codePostal $ville"
    }
}
