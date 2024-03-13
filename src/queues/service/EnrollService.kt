package queues.service

import queues.data.Enroll
import queues.data.Student
import queues.queue.Queue
import java.time.LocalDateTime
import java.util.UUID

class EnrollService {
    private val queue = Queue()
    private val enrolledStudents = mutableListOf<Student>()

    fun registerWaitingQueue(studentName: String) {
        queue.add(studentName)
        println(">> Student $studentName added to waiting queues.queue")
    }

    fun enrollStudent(): UUID? {
        val student = queue.remove()

        return if (student != null) {
            student.enroll()
            enrolledStudents.add(student)
            println(">> Student ${student.name} successfully enrolled. Enroll: ${student.enroll} ")
            student.enroll.id
        } else {
            println("No students in the waiting queues.queue for enrollment.")
            null
        }
    }

    fun undoEnroll(enrollId: UUID?) {
        val student = enrolledStudents.find { it.enroll.id == enrollId }
        if (student != null) {
            enrolledStudents.remove(student)
            println("<< Enroll student ${student.name} successfully undone")
        } else {
            println("Enroll not found")
        }
    }

    fun listEnrolledStudents() {
        println("List of enrolled students:")
        if (enrolledStudents.isEmpty()) {
            println("There are no students enrolled")
        } else {
            enrolledStudents.forEach {
                println(
                    "${it.name} - Enroll: ${it.enroll}, " +
                            "Curse: ${it.enroll.curse}, " +
                            "EnrollDate: ${it.enroll.registerDate}"
                )
            }
        }
    }

    private fun Student.enroll() {
        this.enroll = Enroll(
            id = UUID.randomUUID(),
            curse = "Análise e Desenvolvimento de Sistemas",
            registerDate = LocalDateTime.now()
        )
    }
}
