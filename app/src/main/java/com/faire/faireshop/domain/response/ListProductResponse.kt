package com.faire.faireshop.domain.response

class ProductResponse(
    val productImage: String,
    val productName: String,
    val detailsText: String,
    val wholesalePrice: PriceResponse,
)

class PriceResponse(
    val price: Double
)
