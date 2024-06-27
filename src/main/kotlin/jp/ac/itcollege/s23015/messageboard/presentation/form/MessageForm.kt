package jp.ac.itcollege.s23015.messageboard.presentation.form

import jp.ac.itcollege.s23015.messageboard.domain.model.MessageWithThreads
import kotlinx.serialization.Serializable

@Serializable
data class GetMessageListResponse(val messageList: List<MessageInfo>)

@Serializable
data class MessageInfo(
    val id: Long,
    val title: String,
    val view_name : String,
    val isThreads: Boolean
){
    constructor(model: MessageWithThreads) : this(
        model.message.id,
        model.message.thread,
        model.message.user,
        model.isThreads,
    )
}