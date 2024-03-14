package tree.interfaces.impls

import tree.data.BinaryTree
import tree.data.Node
import tree.interfaces.IBinaryTreePrint

class BinaryTreePrint : IBinaryTreePrint {
    override fun printInOrder(tree: BinaryTree) {
        if (tree.root == null) {
            println("A árvore está vazia")
        } else {
            inOrderRec(tree.root)
            println()
        }
    }

    override fun printPreOrder(tree: BinaryTree) {
        if (tree.root == null) {
            println("A árvore está vazia")
        } else {
            preOrderRec(tree.root)
            println()
        }
    }

    override fun printPostOrder(tree: BinaryTree) {
        if (tree.root == null) {
            println("A árvore está vazia")
        } else {
            postOrderRec(tree.root)
            println()
        }
    }

    private fun inOrderRec(node: Node?) {
        node?.let {
            inOrderRec(it.left)
            print("${it.key} ")
            inOrderRec(it.right)
        }
    }

    private fun preOrderRec(node: Node?) {
        node?.let {
            print("${it.key} ")
            preOrderRec(it.left)
            preOrderRec(it.right)
        }
    }

    private fun postOrderRec(node: Node?) {
        node?.let {
            postOrderRec(it.left)
            postOrderRec(it.right)
            print("${it.key} ")
        }
    }
}
