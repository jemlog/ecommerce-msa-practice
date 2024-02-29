package study.studyuserservice.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long> {

    fun findByUserId(userId: String): User?
}