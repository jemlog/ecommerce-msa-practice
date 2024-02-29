package study.studyapigatewayservice.filter

import io.jsonwebtoken.JwtParser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.core.io.buffer.DataBuffer
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec


@Component
class AuthorizationHeaderFilter: AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>(Config::class.java) {

    @Value("\${token.secret}")
    lateinit var tokenSecret: String

    companion object Config{

    }

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->

            val request = exchange.request

            if(!request.headers.containsKey(HttpHeaders.AUTHORIZATION)){
                return@GatewayFilter onError(exchange, "No Authorization Header", HttpStatus.UNAUTHORIZED)
            }

            val authorizationHeader = request.headers[HttpHeaders.AUTHORIZATION]!![0]
            val jwt = authorizationHeader.replace("Bearer", "")

            if (!isJwtValid(jwt)) {
                return@GatewayFilter onError(exchange, "JWT token is not valid", HttpStatus.UNAUTHORIZED);
            }

            return@GatewayFilter chain.filter(exchange)
        }
    }

    private fun onError(exchange: ServerWebExchange, err: String, httpStatus: HttpStatus): Mono<Void> {
        val response = exchange.response
        response.setStatusCode(httpStatus)
        val bytes: ByteArray = "The requested token is invalid.".toByteArray(StandardCharsets.UTF_8)
        val buffer: DataBuffer = exchange.response.bufferFactory().wrap(bytes)
        return response.writeWith(Flux.just(buffer))
    }

    private fun isJwtValid(jwt: String): Boolean {
        val secretKeyBytes: ByteArray = Base64.getEncoder().encode(tokenSecret.toByteArray())
        val signingKey: SecretKey = SecretKeySpec(secretKeyBytes, SignatureAlgorithm.HS512.jcaName)
        var returnValue = true
        var subject: String? = null
        try {
            val jwtParser: JwtParser = Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
            subject = jwtParser.parseClaimsJws(jwt).body.subject
        } catch (ex: Exception) {
            returnValue = false
        }
        if (subject.isNullOrEmpty()) {
            returnValue = false
        }
        return returnValue
    }
}