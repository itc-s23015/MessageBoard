package jp.ac.itcollege.s23015.messageboard.domain.repository

import jp.ac.itcollege.s23015.messageboard.domain.model.Threads

interface ThreadsRepository {
    fun createThread(thread: Threads): Threads

    fun getThreadById(id: Long): Threads?

    fun getAllThreads(): List<Threads>

    fun updateThread(thread: Threads): Threads

    fun deleteThread(id: Long)
}