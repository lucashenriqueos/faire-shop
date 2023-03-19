package com.faire.faireshop.domain.service

import com.faire.faireshop.domain.response.ProductResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface FaireService {
    @GET("products-response.json")
    fun listProducts(): Single<List<ProductResponse>>
}