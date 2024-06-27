package jp.ac.itcollege.s23015.messageboard.presentation.controller

import jp.ac.itcollege.s23015.message.board.presentation.form.GetUserInfoResponse
import jp.ac.itcollege.s23015.message.board.presentation.form.PostUserRegisterRequest
import jp.ac.itcollege.s23015.messageboard.application.service.UserService
import jp.ac.itcollege.s23015.messageboard.application.service.sequrity.MessageBoardUserDetails
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin
class UserController (
    private val userService: UserService
){
    @PostMapping("/register")
    fun register(@RequestBody user: PostUserRegisterRequest){
        user.run {
            userService.register(viewName, email, password)
        }
    }

    @GetMapping("/info")
    fun getInfo(
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): GetUserInfoResponse {
        return userService.find(user.getId()).run {
            GetUserInfoResponse(id, viewName)
        }
    }
}