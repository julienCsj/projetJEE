import toulousemusee.JeuTestCsvService
import toulousemusee.Musee

class BootStrap {

    JeuTestCsvService jeuTestCsvService

    def init = { servletContext ->
        jeuTestCsvService.parseCsv()
    }
    def destroy = {
    }
}
