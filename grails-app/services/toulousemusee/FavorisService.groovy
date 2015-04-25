package toulousemusee

import grails.transaction.Transactional

@Transactional
class FavorisService {

    static scope = "session"

    def listeFavoris = new ArrayList<Musee>();

    def ajouterAuxFavoris(String id) {
        Musee musee = Musee.findById(id)
        print "********* MUSEE = "+musee
        if (! listeFavoris.find()?.getId().equals(id))
            listeFavoris.add(musee)
    }

    def retirerDesFavoris(String id) {
        Musee musee = Musee.findById(id)
        listeFavoris.removeAll {it.id == id};
    }
}
