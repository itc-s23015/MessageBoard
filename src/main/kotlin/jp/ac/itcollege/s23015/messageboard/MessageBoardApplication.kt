package jp.ac.itcollege.s23015.messageboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MessageBoardApplication

fun main(args: Array<String>) {
    runApplication<MessageBoardApplication>(*args)
}
