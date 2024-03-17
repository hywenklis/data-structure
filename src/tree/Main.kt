package tree

import tree.functions.Delete
import tree.functions.Insert
import tree.functions.Fetch

fun main() {
    val insert = Insert()
    val delete = Delete(insert)
    val fetch = Fetch()
    val binaryTree = BinaryTree(insert, delete, fetch)

    binaryTree.insert(15)
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