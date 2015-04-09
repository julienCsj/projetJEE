package toulousemusee

import grails.transaction.Transactional

@Transactional
class FavorisService {

    static scope = "session"

    def listeFavoris = new ArrayList<Musee>();

    def ajouterAuxFavoris(Musee musee) {
        listeFavoris.contains(musee)?:listeFavoris.add(musee)
        listeFavoris
    }

    def retirerDesFavoris(Musee musee) {
        listeFavoris.remove(listeFavoris.indexOf(musee))
        listeFavoris
    }
}
