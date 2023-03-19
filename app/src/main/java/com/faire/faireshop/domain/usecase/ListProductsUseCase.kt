package com.faire.faireshop.domain.usecase

import com.faire.faireshop.domain.response.ProductResponse
import com.faire.faireshop.domain.service.FaireService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ListProductsUseCase(private val faireService: FaireService) {
    fun execute(): Single<List<ProductResponse>> = faireService.listProducts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .delay(2, TimeUnit.SECONDS)
}