package tree

import tree.data.TreeNode
import tree.functions.TreeDelete
import tree.functions.TreeFetch
import tree.functions.TreeInsertion

class BinaryTree(
    private val insert: TreeInsertion,
    private val delete: TreeDelete,
    private val fetch: TreeFetch
) {
    private var root: TreeNode? = null

    fun insert(data: Int) {
        root = insert.insertNode(root, data)
    }

    fun delete(data: Int) {
        root = delete.deleteNode(root, data)
    }

    fun inorderTraversal() = fetch.inOrderRecursive(root)
    fun printTree() = fetch.printTreeRecursive(root, 0)

}