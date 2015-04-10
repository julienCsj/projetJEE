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

        render(view: 'listeMusee', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size()])
    }

    def supprimerFavoris(Musee musee) {
        /*if(session['favoris']) {
            session['favoris'] = new ArrayList<Musee>(session['favoris'])
        } else {
            session['favoris'] = new ArrayList<Musee>()
        }*/
        favorisService.retirerDesFavoris(musee)

        render(view: 'listeMusee', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size()])
    }
}
