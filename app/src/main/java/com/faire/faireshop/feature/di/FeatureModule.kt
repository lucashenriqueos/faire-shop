package com.faire.faireshop.feature.di

import com.faire.faireshop.feature.main.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val featureModule = module {
    viewModelOf(::ProductListViewModel)
}