package jp.ac.itcollege.s23015.messageboard.infrastructure.database.dao

import jp.ac.itcollege.s23015.messageboard.domain.model.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UsersEntity (id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UsersEntity>(UsersTable)

    var email by UsersTable.email
    var password by UsersTable.password
    var viewName by UsersTable.viewName

    fun toUser(): Users {
        return Users(id.value, email, password, viewName)
    }
}