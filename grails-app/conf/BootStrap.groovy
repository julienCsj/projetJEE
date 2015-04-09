import toulousemusee.JeuTestCsvService

class BootStrap {

    JeuTestCsvService jeuTestCsvService

    def init = { servletContext ->
        jeuTestCsvService.parseCsv()
    }
    def destroy = {
    }
}
