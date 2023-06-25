package com.smarthome.shorderservice.repo

import com.smarthome.shorderservice.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface OrderRepository : JpaRepository<Order, Long> {

    fun findByOrderId(orderId: String): Optional<Order>
}
