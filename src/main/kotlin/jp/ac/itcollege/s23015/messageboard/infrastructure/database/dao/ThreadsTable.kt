package jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object ThreadsTable : LongIdTable("thread") {
    val title = varchar("title", 256)
    val userId = reference("user_id", UsersTable)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
    val deleted = bool("deleted").default(false)
}