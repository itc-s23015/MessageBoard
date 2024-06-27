package jp.ac.itcollege.s23015.messageboard.domain.repository

import jp.ac.itcollege.s23015.messageboard.domain.model.ThreadsWithUser
import java.time.LocalDate

interface ThreadsRepository {
    fun findAllWithThreads(): List<ThreadsWithUser>
    fun update(id: Long, title: String?, creator: String?, releaseDate: LocalDate)
    fun delete(id: Long, userId: Long)
}