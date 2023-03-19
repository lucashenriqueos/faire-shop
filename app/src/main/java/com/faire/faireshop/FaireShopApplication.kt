package com.faire.faireshop

import android.app.Application
import com.faire.faireshop.core.coreModule
import com.faire.faireshop.domain.domainModule
import com.faire.faireshop.feature.di.featureModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class FaireShopApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@FaireShopApplication)
            modules(coreModule, domainModule, featureModule)
        }
    }
}