package queues

import queues.service.EnrollService

fun main() {
    val enrollSystem = EnrollService()

    enrollSystem.listEnrolledStudents()

    enrollSystem.registerWaitingQueue("Hywenklis")
    enrollSystem.registerWaitingQueue("Rherbert")

    val enrollId = enrollSystem.enrollStudent()
    enrollSystem.enrollStudent()
    enrollSystem.enrollStudent()

    enrollSystem.listEnrolledStudents()

    enrollSystem.undoEnroll(enrollId)

    enrollSystem.listEnrolledStudents()
}