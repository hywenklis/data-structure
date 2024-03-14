package tree.interfaces

import tree.data.BinaryTree

interface IBinaryTreePrint {
    fun printInOrder(tree: BinaryTree)
    fun printPreOrder(tree: BinaryTree)
    fun printPostOrder(tree: BinaryTree)
}