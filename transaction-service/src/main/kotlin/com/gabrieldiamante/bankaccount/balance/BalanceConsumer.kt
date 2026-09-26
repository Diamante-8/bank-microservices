package com.gabrieldiamante.bankaccount.balance

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.eclipse.microprofile.reactive.messaging.Incoming
import java.math.BigDecimal

@ApplicationScoped
class BalanceConsumer {

    private val objectMapper = ObjectMapper()

    @Incoming("transaction-in")
    @Transactional
    fun consume(message: String) {
        val jsonNode: JsonNode = objectMapper.readTree(message)
        val type = jsonNode.get("type").asText()
        val amount = jsonNode.get("amount").decimalValue()

        // Lógica simples de CQRS/Consumo: atualiza ou cria o registro de saldo
        // Simple CQRS/Consumption logic: updates or creates the balance record
        var balance = Balance.findAll().firstResult() as Balance?
        if (balance == null) {
            balance = Balance().apply { this.amount = BigDecimal.ZERO }
        }

        if (type.equals("DEPOSIT", ignoreCase = true) || type.equals("INCOME", ignoreCase = true)) {
            balance.amount = balance.amount.add(amount)
        } else {
            balance.amount = balance.amount.subtract(amount)
        }

        balance.persist()
    }
}