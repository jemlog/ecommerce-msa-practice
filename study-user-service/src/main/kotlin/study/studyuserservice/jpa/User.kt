package study.studyuserservice.jpa

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class User (

    val name: String, // 프로퍼티에 알아서 getter가 붙는다

    var email: String,

    var userId: String,

    var encryptedPwd: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // default 파라미터는 가장 아래에 있는게 관례
) {

    // 초기화할때 제약 조건이 필요한 경우
    init{
        if(name.isBlank()){
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다")
        }
    }

}