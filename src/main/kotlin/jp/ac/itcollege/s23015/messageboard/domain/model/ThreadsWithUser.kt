package jp.ac.itcollege.s23015.messageboard.domain.model

import java.time.LocalDateTime

data class ThreadsWithUser(
    val id:Long,
    val title: String,
    val userId : Long,
    val username: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deleted: Boolean
)
