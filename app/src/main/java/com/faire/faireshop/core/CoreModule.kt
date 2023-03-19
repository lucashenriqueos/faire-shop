package com.faire.faireshop.core

import org.koin.dsl.module

val coreModule = module {
    factory { Network().retrofit }
}