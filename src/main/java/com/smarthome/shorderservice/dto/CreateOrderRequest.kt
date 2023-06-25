package com.smarthome.shorderservice.dto

data class CreateOrderRequest(
    val reqId: String,
    val userId: String,
    val productId: String,
)
