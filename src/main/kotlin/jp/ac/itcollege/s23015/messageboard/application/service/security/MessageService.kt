package jp.ac.itcollege.s23015.messageboard.application.service.security

import jp.ac.itcollege.s23015.messageboard.domain.model.MessageWithThreads
import jp.ac.itcollege.s23015.messageboard.domain.repository.MessageRepository

class MessageService {
    private val messageRepository: MessageRepository(
    ){
        fun getList(): List<MessageWithThreads> {
            return messageRepository.findAllWithThreads()

        }
    }
}