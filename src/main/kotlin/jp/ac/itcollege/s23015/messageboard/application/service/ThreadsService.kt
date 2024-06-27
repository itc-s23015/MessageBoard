package jp.ac.itcollege.s23015.messageboard.application.service

import jp.ac.itcollege.s23015.messageboard.domain.model.Threads
import jp.ac.itcollege.s23015.messageboard.domain.repository.ThreadsRepository

class ThreadsService (
    private val threadsRepository : ThreadsRepository)
{
    fun createThread(thread: Threads): Threads {
        return threadsRepository.createThread(thread)
    }
}