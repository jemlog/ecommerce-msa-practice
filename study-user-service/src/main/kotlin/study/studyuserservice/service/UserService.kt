package study.studyuserservice.service

import org.springframework.stereotype.Service
import java.util.concurrent.ThreadPoolExecutor

@Service
class UserService(
    val userReader: UserReader,
    val orderReader: OrderReader,
) {

    /*
    Service라는 비즈니스 로직에서는 읽어내려갈때 어떤 구체 기술을 사용했는지 맥락 상에 들어나지 않도록 만들어야 한다
    서킷이나 재시도 등등의 예외 처리는 되도록이면 비즈니스 로직에는 들어나지 않도록 만들기
    명시적으로 어떤 플로우를 통해 예외 처리를 하는지 확인해야 한다면 runCatching 같은 구문으로 넘겨서 비즈니스 로직에서 처리는 가능하다고 생각
     */
    fun getUserByUserId(userId: String){
        val user = userReader.read(userId)
        orderReader.read(userId)
    }
}