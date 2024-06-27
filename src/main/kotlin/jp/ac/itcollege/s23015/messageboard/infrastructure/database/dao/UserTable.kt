package jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object UserTable : LongIdTable("user"){
    val email = varchar("email", 256).uniqueIndex()
    val password = varchar("password", 128)
    val view_name = varchar("name", 32)
}