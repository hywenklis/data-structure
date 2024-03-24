package search

class TrackingSystem {
    private val packageMap: HashMap<String, MutableList<Package>> = HashMap()

    fun addPackage(packageItem: Package) {
        if (packageMap.containsKey(packageItem.trackingCode)) {
            packageMap[packageItem.trackingCode]?.add(packageItem)
        } else {
            packageMap[packageItem.trackingCode] = mutableListOf(packageItem)
        }
    }

    fun searchPackages(trackingCode: String): List<Package>? {
        println("Realizando busca otimizada de pacotes com código de rastreamento: $trackingCode")
        return packageMap[trackingCode]
    }
}