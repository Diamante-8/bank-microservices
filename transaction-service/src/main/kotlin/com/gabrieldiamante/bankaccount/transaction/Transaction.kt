package com.gabrieldiamante.bankaccount.transaction

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "transactions")
class Transaction {

    @Id
    var id: UUID = UUID.randomUUID()

    @Column(nullable = false)
    lateinit var type: String // Ex: DEPOSIT, WITHDRAW

    @Column(nullable = false)
    lateinit var amount: BigDecimal

    @Column
    var description: String? = null

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
}