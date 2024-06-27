package jp.ac.itcollege.s23015.messageboard.domain.model

import java.time.LocalDateTime

data class Threads(
    val id: Long,
    val title: String,
    val userId: Long,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var delete: Boolean
)