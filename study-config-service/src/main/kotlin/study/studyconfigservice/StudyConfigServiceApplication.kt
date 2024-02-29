package study.studyconfigservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class StudyConfigServiceApplication

fun main(args: Array<String>) {
    runApplication<StudyConfigServiceApplication>(*args)
}
