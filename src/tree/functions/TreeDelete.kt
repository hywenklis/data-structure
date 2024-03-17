package tree.functions

import tree.data.TreeNode

class TreeDelete(private val insert: TreeInsertion) {
    fun deleteNode(root: TreeNode?, data: Int): TreeNode? {
        if (root == null) {
            return root
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data)
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data)
        } else {
            if (root.left == null) return root.right
            else if (root.right == null) return root.left

            root.data = minValue(root.right)
            root.right = deleteNode(root.right, root.data)
        }

        updateHeight(root)
        return balanceTree(root)
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

    private fun balanceTree(node: TreeNode?): TreeNode {
        val balance = node?.calculateBalanceFactor(node)

        if (balance!! > 1 && node.calculateBalanceFactor(node.left) >= 0) {
            return insert.rightRotate(node)
        }

        if (balance > 1 && node.calculateBalanceFactor(node.left) < 0) {
            node.left = insert.leftRotate(node.left!!)
            return insert.rightRotate(node)
        }

        if (balance < -1 && node.calculateBalanceFactor(node.right) <= 0) {
            return insert.leftRotate(node)
        }

        if (balance < -1 && node.calculateBalanceFactor(node.right) > 0) {
            node.right = insert.rightRotate(node.right!!)
            return insert.leftRotate(node)
        }

        return node
    }
}