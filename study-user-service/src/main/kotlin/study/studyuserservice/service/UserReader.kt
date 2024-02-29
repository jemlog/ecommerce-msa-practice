package study.studyuserservice.service

import org.springframework.stereotype.Component
import study.studyuserservice.jpa.User
import study.studyuserservice.jpa.UserRepository

/*
구체 기술 단에서 서킷 브레이커나 재시도 등의 예외 처리 다 해줘야 한다.
 */
@Component
class UserReader(val userRepository: UserRepository) {

    fun read(userId: String): User?{
        return userRepository.findByUserId(userId)
    }
}