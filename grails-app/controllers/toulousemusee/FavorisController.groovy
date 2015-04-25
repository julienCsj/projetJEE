package toulousemusee

import grails.converters.JSON

class FavorisController {

    static scope = "prototype"

    def favorisService

    def ajouterFavoris = {
        favorisService.ajouterAuxFavoris(params.telephone)
        render (favorisService.listeFavoris as JSON)
    }

    def supprimerFavoris = {
        favorisService.retirerDesFavoris(params.telephone)
        render (favorisService.listeFavoris as JSON)
    }
}
