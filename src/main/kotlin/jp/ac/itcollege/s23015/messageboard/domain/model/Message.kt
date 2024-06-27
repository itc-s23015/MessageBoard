package jp.ac.itcollege.s23015.messageboard.domain.model

import java.time.LocalDateTime

data class Message(
    val id: Long,
    val thread: Threads,
    val user: User,
    val message: String,
    val postedAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    val deletedAt: Boolean,
)