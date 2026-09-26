package com.gabrieldiamante.bankaccount.transaction

import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TransactionResource {

    @Inject
    lateinit var producer: TransactionOutgoingProducer

    @POST
    @Transactional
    data class TransactionRequest(
        val type: String,
        val amount: java.math.BigDecimal,
        val description: String?
    )

    @POST
    @Transactional
    fun create(request: TransactionRequest): Response {
        // 1. Cria a entidade e salva no banco de dados local
        // 1. Creates the entity and saves it to the local database
        val transaction = Transaction().apply {
            type = request.type
            amount = request.amount
            description = request.description
        }
        transaction.persist() // Panache Active Record do Quarkus | Quarkus Panache Active Record

        // 2. Publica o evento no Kafka de forma assíncrona
        // 2. Publishes the event to Kafka asynchronously
        producer.sendTransaction(transaction)

        return Response.Status.CREATED.let { Response.status(it).entity(transaction).build() }
    }
}