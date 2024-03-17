package tree.functions

import tree.data.TreeNode

class Delete(private val insert: Insert) {
    fun recursive(root: TreeNode?, data: Int): TreeNode? {
        if (root == null) {
            return root
        }

        if (data < root.data) {
            root.left = recursive(root.left, data)
        } else if (data > root.data) {
            root.right = recursive(root.right, data)
        } else {
            if (root.left == null) return root.right
            else if (root.right == null) return root.left

            root.data = minValue(root.right)
            root.right = recursive(root.right, root.data)
        }

        updateHeight(root)
        return balance(root)
    }

    private fun minValue(node: TreeNode?): Int {
        var minValue = node!!.data
        var current = node
        while (current != null) {
            minValue = current.data
            current = current.left
        }
        return minValue
    }

    private fun updateHeight(node: TreeNode?) {
        node?.let {
            node.height = 1 + maxOf(node.height(node.left), node.height(node.right))
        }
    }

    private fun balance(node: TreeNode?): TreeNode {
        val balance = node?.balanceFactor(node)

        if (balance!! > 1 && node.balanceFactor(node.left) >= 0) {
            return insert.rightRotate(node)
        }

        if (balance > 1 && node.balanceFactor(node.left) < 0) {
            node.left = insert.leftRotate(node.left!!)
            return insert.rightRotate(node)
        }

        if (balance < -1 && node.balanceFactor(node.right) <= 0) {
            return insert.leftRotate(node)
        }

        if (balance < -1 && node.balanceFactor(node.right) > 0) {
            node.right = insert.rightRotate(node.right!!)
            return insert.leftRotate(node)
        }

        return node
    }
}