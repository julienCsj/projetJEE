package toulousemusee

import grails.transaction.Transactional

@Transactional
class FavorisService {

    static scope = "session"

    def listeFavoris = new ArrayList<Musee>();

    def ajouterAuxFavoris(String telephone) {
        def musee = Musee.findByTelephone(telephone)
        listeFavoris.contains(musee)?:listeFavoris.add(musee)
    }

    def retirerDesFavoris(String telephone) {
        def musee = Musee.findByTelephone(telephone)
        listeFavoris.remove(musee)
    }
}
