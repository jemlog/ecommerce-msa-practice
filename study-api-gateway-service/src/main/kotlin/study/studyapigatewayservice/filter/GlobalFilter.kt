package study.studyapigatewayservice.filter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

/*
Global Filter Template
 */
@Component
class GlobalFilter : AbstractGatewayFilterFactory<GlobalFilter.Config>(Config::class.java) {

    val logger: Logger = LoggerFactory.getLogger(GlobalFilter::class.java)

    @Override
    override fun apply(config: Config): GatewayFilter {

        return GatewayFilter { exchange, chain ->

            val request = exchange.request
            val response = exchange.response
            return@GatewayFilter chain.filter(exchange).then(Mono.fromRunnable { logger.info("hello") })
        }
    }

    companion object Config{

    }
}