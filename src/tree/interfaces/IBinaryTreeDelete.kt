package tree.interfaces

import tree.data.BinaryTree

interface IBinaryTreeDelete {
    fun deleteKey(tree: BinaryTree, key: Int)
}