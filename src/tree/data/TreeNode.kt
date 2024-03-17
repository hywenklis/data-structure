package tree.data

data class TreeNode(
    var data: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null,
    var height: Int = 1
) {

    fun height(node: TreeNode?): Int = node?.height ?: 0
    fun balanceFactor(node: TreeNode?): Int = height(node?.left) - height(node?.right)
}
