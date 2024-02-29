package study.studyuserservice

import org.springframework.web.bind.annotation.RestController
import study.studyuserservice.service.UserService

@RestController
class UsersController(val userService: UserService) {




}