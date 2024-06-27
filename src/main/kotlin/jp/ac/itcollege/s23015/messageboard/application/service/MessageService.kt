package jp.ac.itcollege.s23015.messageboard.application.service

import jp.ac.itcollege.s23015.messageboard.domain.model.Messages
import jp.ac.itcollege.s23015.messageboard.domain.repository.MessagesRepository

class MessageService (
    private val messagesRepository: MessagesRepository)
{
    fun createMessage(message: Messages): Messages {
        return messagesRepository.createMessage(message)
    }
}