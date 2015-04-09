package toulousemusee

class FavorisController {

    static scope = "prototype"

    def favorisService

    def ajouterFavoris(Musee musee) {
        /*if(session['favoris']) {
            session['favoris'] = new ArrayList<Musee>(session['favoris'])
        } else {
            session['favoris'] = new ArrayList<Musee>()
        }*/
        favorisService.ajouterAuxFavoris(musee)
    }

    def supprimerFavoris(Musee musee) {
        /*if(session['favoris']) {
            session['favoris'] = new ArrayList<Musee>(session['favoris'])
        } else {
            session['favoris'] = new ArrayList<Musee>()
        }*/
        favorisService.retirerDesFavoris(musee)
    }
}
