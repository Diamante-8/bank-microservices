package com.gabrieldiamante.bankaccount.transaction

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import com.fasterxml.jackson.databind.ObjectMapper

@ApplicationScoped
class TransactionOutgoingProducer {

    @Inject
    @Channel("transaction-out")
    lateinit var emitter: Emitter<String>

    private val objectMapper = ObjectMapper()

    fun sendTransaction(transaction: Transaction) {
        // Converte o objeto da transação em JSON para enviar ao Kafka
        // Convert the transaction object to JSON to send to Kafka
        val jsonString = objectMapper.writeValueAsString(transaction)
        emitter.send(jsonString)
    }
}