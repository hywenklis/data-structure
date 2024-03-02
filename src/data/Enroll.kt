package data

import java.time.LocalDateTime
import java.util.UUID

data class Enroll(var id: UUID = UUID.randomUUID(), var curse: String = "", var registerDate: LocalDateTime = LocalDateTime.now())