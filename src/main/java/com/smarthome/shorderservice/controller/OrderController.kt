package com.smarthome.shorderservice.controller

import com.smarthome.shorderservice.dto.CreateOrderRequest
import com.smarthome.shorderservice.entity.Order
import com.smarthome.shorderservice.service.OrderService
import com.smarthome.shorderservice.util.HeaderUtil
import com.smarthome.shorderservice.util.ResponseUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/v1/order")
class OrderController(
    private val orderService: OrderService,
    @Value("\${spring.application.name}")
    private val applicationName: String
) {
    private val log: Logger = LoggerFactory.getLogger(OrderController::class.java)

    private val ENTITY_NAME = "order"

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Long): ResponseEntity<Order> {
        log.debug("REST request to get $ENTITY_NAME : {}", id)
        return ResponseUtil.wrapOrNotFound(orderService.getOrder(id))
    }

    // TODO add @Valid
    @PostMapping("/create")
    fun createOrder(@RequestBody req: CreateOrderRequest): ResponseEntity<Order> {
        log.debug("REST request to create $ENTITY_NAME : {}", req)
        val order = orderService.createOrder(req)
        return ResponseEntity.created(URI("/api/order/${order.id}"))
            .headers(
                HeaderUtil.createEntityCreationAlert(
                    applicationName, false, ENTITY_NAME, order.id.toString()
                )
            )
            .body(order)
    }

}