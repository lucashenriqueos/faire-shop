package com.faire.faireshop.domain

import com.faire.faireshop.domain.service.FaireService
import com.faire.faireshop.domain.usecase.ListProductsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val domainModule = module {
    factory<FaireService> { get<Retrofit>().create(FaireService::class.java) }

    factoryOf(::ListProductsUseCase)
}