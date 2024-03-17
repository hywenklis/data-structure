package tree.functions

import tree.data.TreeNode

class TreeFetch {
    fun inOrderRecursive(node: TreeNode?) {
        if (node != null) {
            inOrderRecursive(node.left)
            print("${node.data} ")
            inOrderRecursive(node.right)
        }
    }

    fun printTreeRecursive(node: TreeNode?, level: Int) {
        if (node != null) {
            printTreeRecursive(node.right, level + 1)
            println(" ".repeat(level * 4) + node.data)
            printTreeRecursive(node.left, level + 1)
        }
    }
}