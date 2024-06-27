package jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.CurrentDateTime
import org.jetbrains.exposed.sql.javatime.datetime

object MessageTable : LongIdTable("message") {
    val thread = reference("thread_id", ThreadsTable)
    val user = reference("user_id", UserTable)
    val message = text("message")
    val postedAt = datetime("posted_at").defaultExpression(CurrentDateTime)
    val updatedAt = datetime("updated_at").defaultExpression(CurrentDateTime)
    val deleted = bool("deleted").default(false)
}