package tree

import tree.data.BinaryTree
import tree.interfaces.IBinaryTreeDelete
import tree.interfaces.IBinaryTreeInsert
import tree.interfaces.IBinaryTreePrint
import tree.interfaces.impls.BinaryTreeDelete
import tree.interfaces.impls.BinaryTreeInsert
import tree.interfaces.impls.BinaryTreePrint


fun main() {
    val tree = BinaryTree()

    val insert: IBinaryTreeInsert = BinaryTreeInsert()

    println("Inserindo dados na Arvore")
    insert.insert(tree, 50)
    insert.insert(tree, 30)
    insert.insert(tree, 20)
    insert.insert(tree, 40)
    insert.insert(tree, 70)
    insert.insert(tree, 60)
    insert.insert(tree, 80)

    val print: IBinaryTreePrint = BinaryTreePrint()
    println("Impressão em ordem após inserções:")
    print.printInOrder(tree)

    println("Tentando inserir um nó que já existe (50):")
    insert.insert(tree, 50)
    print.printInOrder(tree)

    val delete: IBinaryTreeDelete = BinaryTreeDelete()
    println("Deletando 20")
    delete.deleteKey(tree, 20)
    println("Impressão em ordem:")
    print.printInOrder(tree)

    println("Deletando 30")
    delete.deleteKey(tree, 30)
    println("Impressão em ordem:")
    print.printInOrder(tree)

    println("Deletando 50")
    delete.deleteKey(tree, 50)
    println("Impressão em ordem:")
    print.printInOrder(tree)

    println("Tentando deletar um nó que não existe (100):")
    delete.deleteKey(tree, 100)
    print.printInOrder(tree)

    println("Impressão em pré-ordem:")
    print.printPreOrder(tree)

    println("Impressão em pós-ordem:")
    print.printPostOrder(tree)

    println("Deletando todos os nós restantes")
    delete.deleteKey(tree, 40)
    delete.deleteKey(tree, 60)
    delete.deleteKey(tree, 70)
    delete.deleteKey(tree, 80)
    println("Impressão em ordem de uma árvore vazia:")
    print.printInOrder(tree)
}



