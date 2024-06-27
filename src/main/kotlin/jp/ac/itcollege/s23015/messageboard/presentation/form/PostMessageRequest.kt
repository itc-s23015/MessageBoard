package jp.ac.itcollege.s23015.messageboard.presentation.form

import kotlinx.datetime.LocalDateTime

data class PostMessageRequest(
    val threadId: Long,
    val userId: Long,
    val message: String,
    val postedAt: LocalDateTime
)
