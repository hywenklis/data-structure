package tree

import tree.functions.TreeDelete
import tree.functions.TreeInsertion
import tree.functions.TreeFetch

fun main() {
    val insert = TreeInsertion()
    val delete = TreeDelete(insert)
    val fetch = TreeFetch()
    val binaryTree = BinaryTree(insert, delete, fetch)

    binaryTree.insert(15)
    binaryTree.insert(50)
    binaryTree.insert(78)
    binaryTree.insert(1)
    binaryTree.insert(43)
    binaryTree.insert(5)
    binaryTree.insert(10)
    binaryTree.insert(3)
    binaryTree.insert(12)
    binaryTree.insert(17)

    println("Inorder traversal of the constructed binary tree:")
    binaryTree.inorderTraversal()

    println("\n\nTree Structure:")
    binaryTree.printTree()

    println("\n\nAfter deletion of 15:")
    binaryTree.delete(15)
    binaryTree.inorderTraversal()

    println("\n\nTree Structure after deletion:")
    binaryTree.printTree()
}