package jp.ac.itcollege.s23015.messageboard.domain.model

import kotlinx.datetime.LocalDateTime


data class Threads(
    val id: Long,
    val title: String,
    val userId: Long,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var deleted: Boolean
)