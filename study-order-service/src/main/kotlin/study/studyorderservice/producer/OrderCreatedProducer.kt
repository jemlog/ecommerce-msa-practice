package study.studyorderservice.producer

import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class OrderCreatedProducer(val kafkaTemplate: KafkaTemplate<String, Long>) {

    companion object{
        const val ORDER_CREATED_TOPIC = "order-created-topic"
    }

    fun send(orderId: Long){
        kafkaTemplate.send(ProducerRecord(ORDER_CREATED_TOPIC, orderId))
    }
}