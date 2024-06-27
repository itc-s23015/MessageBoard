package jp.ac.itcollege.s23015.messageboard.domain.repository

import jp.ac.itcollege.s23015.messageboard.domain.model.Messages

interface MessagesRepository {
    fun createMessage(messages: Messages): Messages

    fun getMessageById(id: Long): Messages?

    fun getMessageByThreadId(threadId : Long): List<Messages>

    fun updateMessage(messages: Messages) : Messages

    fun deleteMessage(id: Long)
}