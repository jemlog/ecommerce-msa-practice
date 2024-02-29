package study.studyuserservice.service

import study.studyuserservice.jpa.User

data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int?,
) {
    companion object {
        fun of(user: User): UserResponse{
            return UserResponse(
                id = user.id!!,
                name = user.name,
                1
            )
        }
    }
}