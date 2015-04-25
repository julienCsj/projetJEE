package toulousemusee

import grails.transaction.Transactional

@Transactional
class FavorisService {

    static scope = "session"

    def listeFavoris = new HashMap<Integer, Musee>();

    def ajouterAuxFavoris(int id) {
        Musee musee = Musee.findById(id)
        print "********* MUSEE = "+musee
        if(musee)
            listeFavoris.put(id, musee)

    }

    def retirerDesFavoris(int id) {
        listeFavoris.remove(id)
    }
}
