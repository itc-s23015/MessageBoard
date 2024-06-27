package jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MessageEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<MessageEntity>(MessageTable)
    var thread by ThreadsEntity referencedOn MessageTable.thread
    var user by UserEntity referencedOn MessageTable.user
    var message by MessageTable.message
    var postedAt by MessageTable.postedAt
    var updatedAt by MessageTable.updatedAt
    var deleted by MessageTable.deleted
    override fun toString() = """
        MessageEntity(id=$id, thread=$thread, message=$message, postedAt=$postedAt, updatedAt=$updatedAt, deleted=$deleted)
    """.trimIndent()
}