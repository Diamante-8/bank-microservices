package com.gabrieldiamante.bankaccount.balance

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "balances")
class Balance {

    @Id
    var id: UUID = UUID.randomUUID()

    @Column(nullable = false)
    var amount: BigDecimal = BigDecimal.ZERO
}