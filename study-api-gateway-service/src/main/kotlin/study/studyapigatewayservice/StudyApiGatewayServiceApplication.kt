package study.studyapigatewayservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableDiscoveryClient
class StudyApiGatewayServiceApplication

fun main(args: Array<String>) {
    runApplication<StudyApiGatewayServiceApplication>(*args)
}

