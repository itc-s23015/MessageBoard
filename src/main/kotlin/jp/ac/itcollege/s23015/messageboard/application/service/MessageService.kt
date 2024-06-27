package jp.ac.itcollege.s23015.messageboard.application.service

import jp.ac.itcollege.s23015.messageboard.domain.model.Messages
import jp.ac.itcollege.s23015.messageboard.presentation.form.PostMessageRequest
import jp.ac.itcollege.s23015.messageboard.domain.repository.MessagesRepository
import jp.ac.itcollege.s23015.messageboard.domain.repository.ThreadsRepository

class MessageService (
    private val messagesRepository: MessagesRepository,
    private val threadsRepository : ThreadsRepository
) {
    fun createMessage(request: PostMessageRequest): Messages {
        val message = Messages(
            id = 0,
            threadId = request.threadId,
            userId = request.userId,
            message = request.message,
            postedAt = request.postedAt,
            updatedAt = request.postedAt,
            deleted = false
        )
        val createdMessage = messagesRepository.createMessage(message)

        val thread = threadsRepository.getThreadById(request.threadId)
            ?: throw IllegalArgumentException("Thread not found with id: ${request.threadId}")
        val updatedThread = thread.copy(updatedAt = request.postedAt)
        threadsRepository.updateThread(updatedThread)

        return createdMessage
    }
}