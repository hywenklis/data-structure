package tree

import kotlin.math.max

class TreeNode(var data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var height: Int = 1
}

class BinaryTree {
    private var root: TreeNode? = null

    fun insert(data: Int) {
        root = insertRecursive(root, data)
    }

    private fun insertRecursive(node: TreeNode?, data: Int): TreeNode {
        if (node == null) {
            return TreeNode(data)
        }

        if (data < node.data) {
            node.left = insertRecursive(node.left, data)
        } else if (data > node.data) {
            node.right = insertRecursive(node.right, data)
        }

        updateHeight(node)
        return balance(node)
    }

    private fun updateHeight(node: TreeNode?) {
        node?.height = 1 + max(height(node?.left), height(node?.right))
    }

    private fun height(node: TreeNode?): Int {
        return node?.height ?: 0
    }

    private fun balanceFactor(node: TreeNode?): Int {
        return height(node?.left) - height(node?.right)
    }

    private fun balance(node: TreeNode?): TreeNode {
        val balance = balanceFactor(node)

        if (balance > 1 && balanceFactor(node?.left) >= 0) {
            return rightRotate(node!!)
        }

        if (balance > 1 && balanceFactor(node?.left) < 0) {
            node?.left = leftRotate(node?.left!!)
            return rightRotate(node)
        }

        if (balance < -1 && balanceFactor(node?.right) <= 0) {
            return leftRotate(node!!)
        }

        if (balance < -1 && balanceFactor(node?.right) > 0) {
            node?.right = rightRotate(node?.right!!)
            return leftRotate(node)
        }

        return node!!
    }

    private fun rightRotate(y: TreeNode): TreeNode {
        val x = y.left
        val t2 = x?.right

        x?.right = y
        y.left = t2

        updateHeight(y)
        updateHeight(x)

        return x!!
    }

    private fun leftRotate(x: TreeNode): TreeNode {
        val y = x.right
        val t2 = y?.left

        y?.left = x
        x.right = t2

        updateHeight(x)
        updateHeight(y)

        return y!!
    }

    fun delete(data: Int) {
        root = deleteRecursive(root, data)
    }

    private fun deleteRecursive(root: TreeNode?, data: Int): TreeNode? {
        if (root == null) return root

        if (data < root.data) {
            root.left = deleteRecursive(root.left, data)
        } else if (data > root.data) {
            root.right = deleteRecursive(root.right, data)
        } else {
            if (root.left == null) return root.right
            else if (root.right == null) return root.left

            root.data = minValue(root.right)
            root.right = deleteRecursive(root.right, root.data)
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

    fun inorderTraversal() {
        inorderRecursive(root)
    }

    private fun inorderRecursive(node: TreeNode?) {
        if (node != null) {
            inorderRecursive(node.left)
            print("${node.data} ")
            inorderRecursive(node.right)
        }
    }

    fun printTree() {
        printTreeRecursive(root, 0)
    }

    private fun printTreeRecursive(node: TreeNode?, level: Int) {
        if (node != null) {
            printTreeRecursive(node.right, level + 1)
            println(" ".repeat(level * 4) + node.data)
            printTreeRecursive(node.left, level + 1)
        }
    }
}

fun main() {
    val binaryTree = BinaryTree()
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
