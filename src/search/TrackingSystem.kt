package search

class TrackingSystem {
    private val packageMap: HashMap<String, MutableList<Package>> = HashMap()

    fun addPackage(packageItem: Package) = packageMap.getOrPut(packageItem.trackingCode) { mutableListOf() }.add(packageItem)
    fun searchPackages(trackingCode: String): List<Package>? = packageMap[trackingCode]
}