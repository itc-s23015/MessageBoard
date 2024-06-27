package jp.ac.itcollege.s23015.messageboard.domain.repository

import jp.ac.itcollege.s23015.messageboard.domain.model.Users

interface UsersRepository {
    fun findByEmail(email: String): Users?

    fun findById(id: Long): Users?

    fun createUser(user: Users): Users

    fun updateUser(user: Users): Users

    fun deleteUser(id: Long)

    fun save(user: Users): Users
}