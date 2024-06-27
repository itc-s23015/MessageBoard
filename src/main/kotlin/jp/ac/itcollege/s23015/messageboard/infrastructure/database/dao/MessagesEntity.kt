package jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao

import jp.ac.itcollege.s23015.messageboard.domain.model.Messages
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MessagesEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<MessagesEntity>(MessagesTable)

    var threadId by ThreadsEntity referencedOn MessagesTable.threadId
    var userId by UsersEntity referencedOn MessagesTable.userId
    var message by MessagesTable.message
    var postedAt by MessagesTable.postedAt
    var updatedAt by MessagesTable.updatedAt
    var deleted by MessagesTable.deleted

    fun toMessage(): Messages{
        return Messages(
            id.value,
            threadId.id.value,
            userId.id.value,
            message,
            postedAt,
            updatedAt,
            deleted
        )
    }
}