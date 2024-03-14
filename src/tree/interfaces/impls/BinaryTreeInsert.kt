package tree.interfaces.impls

import tree.data.BinaryTree
import tree.data.Node
import tree.interfaces.IBinaryTreeInsert

class BinaryTreeInsert : IBinaryTreeInsert {
    override fun insert(tree: BinaryTree, key: Int) {
        tree.root = insertRec(tree.root, key)
    }

    private fun insertRec(node: Node?, key: Int): Node {
        node?.let {
            when {
                key < it.key -> {
                    println("Inserindo $key à esquerda de ${it.key}")
                    it.left = insertRec(it.left, key)
                }
                key > it.key -> {
                    println("Inserindo $key à direita de ${it.key}")
                    it.right = insertRec(it.right, key)
                }
                else -> {
                    println("A chave $key já existe na árvore")
                }
            }
            return it
        } ?: return Node(key).also { println("Inserindo $key como raiz") }
    }
}