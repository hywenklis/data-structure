package tree.functions

import tree.data.TreeNode

class TreeInsertion {
    fun insertNode(node: TreeNode?, data: Int): TreeNode =
        node?.let {
            if (data < it.data) {
                it.left = insertNode(it.left, data)
            } else if (data > it.data) {
                it.right = insertNode(it.right, data)
            }

            updateHeight(it)
            balanceTree(it)
        } ?: TreeNode(data)

    private fun updateHeight(node: TreeNode?) =
        node?.let { it.height = 1 + maxOf(it.height(it.left), it.height(it.right)) }

    private fun balanceTree(node: TreeNode?): TreeNode {
        val balanceFactor = node?.calculateBalanceFactor(node)

        return when {
            balanceFactor!! > 1 && node.calculateBalanceFactor(node.left) >= 0 -> rightRotate(node)
            balanceFactor > 1 && node.calculateBalanceFactor(node.left) < 0 -> {
                node.left = leftRotate(node.left!!)
                rightRotate(node)
            }

            balanceFactor < -1 && node.calculateBalanceFactor(node.right) <= 0 -> leftRotate(node)
            balanceFactor < -1 && node.calculateBalanceFactor(node.right) > 0 -> {
                node.right = rightRotate(node.right!!)
                leftRotate(node)
            }

            else -> node
        }
    }

    fun rightRotate(y: TreeNode): TreeNode {
        val x = y.left
        val t2 = x?.right

        x?.right = y
        y.left = t2

        updateHeight(y)
        updateHeight(x)

        return x!!
    }

    fun leftRotate(x: TreeNode): TreeNode {
        val y = x.right
        val t2 = y?.left

        y?.left = x
        x.right = t2

        updateHeight(x)
        updateHeight(y)

        return y!!
    }
}
