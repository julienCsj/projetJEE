package toulousemusee

class Adresse {

    int numero
    String rue
    int codePostal
    String ville

    static constraints = {

    }


    @Override
    public String toString() {
        return '''$numero $rue
                $codePostal $ville
                '''
    }
}