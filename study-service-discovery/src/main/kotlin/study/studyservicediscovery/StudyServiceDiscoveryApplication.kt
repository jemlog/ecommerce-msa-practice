package study.studyservicediscovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class StudyServiceDiscoveryApplication

fun main(args: Array<String>) {
    runApplication<StudyServiceDiscoveryApplication>(*args)
}
