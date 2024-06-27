package jp.ac.itcollege.s23015.messageboard.domain.model

data class MessageWithThreads(
    val message: Message,
    val threads: Thread
){
    val isThreads : Boolean
        get() = threads != null
}
