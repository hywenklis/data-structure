package tree.functions

import tree.data.TreeNode

class Insert {
    fun recursive(node: TreeNode?, data: Int): TreeNode {
        if (node == null) {
            return TreeNode(data)
        }

        if (data < node.data) {
            node.left = recursive(node.left, data)
        } else if (data > node.data) {
            node.right = recursive(node.right, data)
        }

        updateHeight(node)
        return balance(node)
    }

    private fun updateHeight(node: TreeNode?) {
        node?.let {
            node.height = 1 + maxOf(node.height(node.left), node.height(node.right))
        }
    }

    private fun balance(node: TreeNode?): TreeNode {
        val balance = node?.balanceFactor(node)

        if (balance!! > 1 && node.balanceFactor(node.left) >= 0) {
            return rightRotate(node)
        }

        if (balance > 1 && node.balanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left!!)
            return rightRotate(node)
        }

        if (balance < -1 && node.balanceFactor(node.right) <= 0) {
            return leftRotate(node)
        }

        if (balance < -1 && node.balanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right!!)
            return leftRotate(node)
        }

        return node
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