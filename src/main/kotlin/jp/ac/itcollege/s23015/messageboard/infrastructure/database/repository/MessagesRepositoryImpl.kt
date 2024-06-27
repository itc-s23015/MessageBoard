package jp.ac.itcollege.s23015.message.board.infrastructure.database.repository

import jp.ac.itcollege.s23015.messageboard.domain.model.Messages
import jp.ac.itcollege.s23015.messageboard.domain.repository.MessagesRepository
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.MessagesEntity
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.MessagesTable
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.ThreadsEntity
import jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao.UsersEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class MessagesRepositoryImpl: MessagesRepository {
    override fun createMessage(message: Messages): Messages {
        return transaction {
            val newMessage = MessagesEntity.new {
                threadId = ThreadsEntity[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.postedAt
                updatedAt = message.updatedAt
                deleted = message.deleted
            }
            newMessage.toMessage()
        }
    }

    override fun getMessageById(id: Long): Messages? {
        return transaction {
            val message = MessagesEntity.findById(id)
            message?.toMessage()
        }
    }

    override fun getMessageByThreadId(threadId: Long): List<Messages> {
        return transaction {
            MessagesEntity.find { MessagesTable.threadId eq threadId }
                .map { it.toMessage() }
        }
    }

    override fun updateMessage(message: Messages): Messages {
        return transaction {
            val messageEntity = MessagesEntity.findById(message.id)
                ?: throw IllegalArgumentException("Message not found with id: ${message.id}")

            messageEntity.apply {
                threadId = ThreadsEntity[message.threadId]
                userId = UsersEntity[message.userId]
                this.message = message.message
                postedAt = message.postedAt
                updatedAt = message.updatedAt
                deleted = message.deleted
            }

            messageEntity.toMessage()
        }
    }

    override fun deleteMessage(id: Long) {
        transaction {
            MessagesEntity.findById(id)?.delete()
        }
    }
}