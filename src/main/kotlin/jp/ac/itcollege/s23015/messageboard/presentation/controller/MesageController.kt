package jp.ac.itcollege.s23015.messageboard.presentation.controller

import jp.ac.itcollege.s23015.messageboard.application.service.security.MessageService
import jp.ac.itcollege.s23015.messageboard.presentation.form.GetMessageListResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("mesage")
@CrossOrigin
class MessageController {
    private val messageService: MessageService,
}{
    @GetMapping("/MassageList")
    fun geteList() : GetMessageListResponse {
        val messageList = messageService.getList().map(::MessageInfo)
        return GetMessageListResponse(messageList)
    }
}