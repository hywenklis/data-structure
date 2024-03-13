package queues.queue

import queues.data.Node
import queues.data.Student

class Queue {
    private var first: Node? = null
    private var last: Node? = null

    fun add(name: String) {
        val newStudent = Student(name)
        val newNode = Node(newStudent)

        last?.next = newNode
        last = newNode
        first = first ?: newNode
    }

    fun remove(): Student? {
        val studentRemoved = first?.student
        first = first?.next

        if (first == null) {
            last = null
        }

        return studentRemoved
    }

    fun isEmpty() = first == null
}
