package jp.ac.itcollege.s23015.messageboard.domain.model

import kotlinx.datetime.LocalDateTime


data class Messages(
    val id: Long,
    val threadId: Long,
    val userId: Long,
    val message: String,
    val postedAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    val deleted: Boolean,
)