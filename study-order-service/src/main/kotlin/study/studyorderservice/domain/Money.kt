package study.studyorderservice.domain

import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
class Money(val value: BigDecimal) {

    fun add(money: Money): Money{
        return Money(value.add(money.value))
    }

    fun substract(money: Money): Money{
        return Money(value.subtract(money.value))
    }

    companion object{
        val ZERO = Money(BigDecimal.ZERO)
    }
}