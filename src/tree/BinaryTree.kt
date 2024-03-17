package tree

import tree.data.TreeNode
import tree.functions.Delete
import tree.functions.Fetch
import tree.functions.Insert

class BinaryTree(
    private val insert: Insert,
    private val delete: Delete,
    private val fetch: Fetch
) {
    private var root: TreeNode? = null

    fun insert(data: Int) {
        root = insert.recursive(root, data)
    }

    fun delete(data: Int) {
        root = delete.recursive(root, data)
    }

    fun inorderTraversal() = fetch.inOrderRecursive(root)
    fun printTree() = fetch.printTreeRecursive(root, 0)

}