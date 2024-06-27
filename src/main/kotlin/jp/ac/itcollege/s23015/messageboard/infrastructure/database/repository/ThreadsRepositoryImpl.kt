package jp.ac.itcollege.s23015.messageboard.infrastructure.database.repository

import jp.ac.itcollege.s23015.messageboard.domain.model.ThreadsWithUser
import jp.ac.itcollege.s23015.messageboard.domain.repository.ThreadsRepository
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.ThreadsEntity
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.ThreadsTable.title
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.ThreadsTable.user
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.UserEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalDateTime

@Repository
class ThreadsRepositoryImpl : ThreadsRepository {
    override fun findAllWithThreads(): List<ThreadsWithUser> {
        return transaction {
            ThreadsEntity.all().map { threadEntity ->
                val userEntity = UserEntity.findById(threadEntity.user.id.value)
                ThreadsWithUser(
                    id = threadEntity.id.value,
                    title = threadEntity.title,
                    userId = threadEntity.user.id.value,
                    username = userEntity?.view_name ?: "Unknown",
                    createdAt = threadEntity.createdAt,
                    updatedAt = threadEntity.updatedAt,
                    deleted = threadEntity.deleted
                )
            }
        }
    }

    override fun update(id: Long, title: String?, creator: String?, releaseDate: LocalDate) {
        transaction {
            val threadEntity = ThreadsEntity.findById(id)
            if (threadEntity != null) {
                if(title != null && title.isNotBlank()) {
                    threadEntity.title = title
                    threadEntity.updatedAt = LocalDateTime.now()
                }

            }else {
                throw IllegalArgumentException("Thread with id $id not found")
            }
        }
    }

    override fun delete(id: Long, userId: Long) {
        return transaction {
            val threadEntity = ThreadsEntity.findById(id)
            if (threadEntity != null) {
                if (threadEntity.user.id.value == userId) {
                    threadEntity.deleted = true
                    threadEntity.updatedAt = LocalDateTime.now()
                    true
                } else {
                    throw IllegalAccessException("Thread with id $id not found")
                }
            } else {
                throw IllegalArgumentException("Thread with id $id not found")
            }
        }
    }
}