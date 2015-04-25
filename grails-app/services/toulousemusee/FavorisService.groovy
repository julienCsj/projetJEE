package toulousemusee

import grails.transaction.Transactional

@Transactional
class FavorisService {

    static scope = "session"

    def listeFavoris = new ArrayList<Musee>();

    def ajouterAuxFavoris(String telephone) {
        def musee = Musee.findByTelephone(telephone)
        if (! listeFavoris.find()?.getTelephone().equals(telephone))
            listeFavoris.add(musee)
    }

    def retirerDesFavoris(String telephone) {
        listeFavoris.removeAll {it.telephone == telephone};
    }
}
