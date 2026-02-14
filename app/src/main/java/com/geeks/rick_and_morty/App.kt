package com.geeks.rick_and_morty

import android.app.Application
import com.geeks.rick_and_morty.data.di.dataModule
import com.geeks.rick_and_morty.domain.di.domainModule
import com.geeks.rick_and_morty.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(level = Level.DEBUG)

            modules(
                dataModule, domainModule, networkModule
            )
        }
    }

}