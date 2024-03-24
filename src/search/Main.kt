package search

fun main() {
    val trackingSystem = TrackingSystem()

    // Adding some packages to the system
    trackingSystem.addPackage(Package("ABC123", "Em Trânsito"))
    trackingSystem.addPackage(Package("DEF456", "Entregue"))
    trackingSystem.addPackage(Package("ABC123", "Aguardando Retirada"))
    trackingSystem.addPackage(Package("GHI789", "Aguardando Retirada"))
    trackingSystem.addPackage(Package("JKL012", "Em Trânsito"))
    trackingSystem.addPackage(Package("MNO345", "Em Trânsito"))
    trackingSystem.addPackage(Package("PQR678", "Entregue"))

    // Performing searches and printing results
    performSearchAndPrint(trackingSystem, "ABC123")
    performSearchAndPrint(trackingSystem, "DEF456")
    performSearchAndPrint(trackingSystem, "GHI789")
    performSearchAndPrint(trackingSystem, "JKL012")
    performSearchAndPrint(trackingSystem, "MNO345")
    performSearchAndPrint(trackingSystem, "PQR678")
    performSearchAndPrint(trackingSystem, "XYZ999")
}

fun performSearchAndPrint(trackingSystem: TrackingSystem, trackingCode: String) {
    val searchResults = trackingSystem.searchPackages(trackingCode)

    if (searchResults != null) {
        println("Status do pacote com código $trackingCode:")
        for (packageItem in searchResults) {
            println("- ${packageItem.status}")
        }
    } else {
        println("Pacote com código $trackingCode não encontrado.")
    }
}