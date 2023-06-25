package com.smarthome.shorderservice.service

import com.smarthome.shorderservice.dto.CreateOrderRequest
import com.smarthome.shorderservice.entity.Order
import com.smarthome.shorderservice.repo.OrderRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun getOrder(id: Long): Optional<Order> = orderRepository.findById(id)
    fun getOrder(orderID: String): Optional<Order> = orderRepository.findByOrderId(orderID)
    fun createOrder(req: CreateOrderRequest): Order {
        TODO("Not yet implemented")
    }


}
