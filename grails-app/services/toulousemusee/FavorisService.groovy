package toulousemusee

import grails.transaction.Transactional

@Transactional
class FavorisService {

    static scope = "session"

    def listeFavoris = new HashMap<Integer, Musee>();

    def ajouterAuxFavoris(int id) {
        Musee musee = Musee.findById(id)
        if(musee)
            listeFavoris.put(id, musee)
        listeFavoris.sort()
    }

    def retirerDesFavoris(int id) {
        listeFavoris.remove(id)
        listeFavoris.sort()
    }
}
