package tree.interfaces.impls

import tree.data.BinaryTree
import tree.data.Node
import tree.interfaces.IBinaryTreeDelete

class BinaryTreeDelete : IBinaryTreeDelete {
    override fun deleteKey(tree: BinaryTree, key: Int) {
        tree.root = deleteRec(tree.root, key)
    }

    private fun deleteRec(node: Node?, key: Int): Node? {
        node ?: return null.also { println("A chave $key não existe na árvore") }

        when {
            key < node.key -> node.left = deleteRec(node.left, key)
            key > node.key -> node.right = deleteRec(node.right, key)
            else -> {
                if (node.left == null) return node.right
                else if (node.right == null) return node.left

                node.key = minValue(node.right!!)
                node.right = deleteRec(node.right, node.key)
            }
        }
        return node
    }

    private fun minValue(node: Node): Int {
        var minv = node.key
        var current = node
        while (current.left != null) {
            minv = current.left!!.key
            current = current.left!!
        }
        return minv
    }
}