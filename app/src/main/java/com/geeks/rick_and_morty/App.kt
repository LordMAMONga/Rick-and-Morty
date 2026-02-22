package com.geeks.rick_and_morty

import android.app.Application
import com.geeks.character.data.di.dataModule
import com.geeks.character.domain.di.domainModule
import com.geeks.character.ui.di.uiModule
import com.geeks.core.network.di.networkModule
import com.geeks.episode.data.di.episodeDataModule
import com.geeks.episode.domain.di.episodeDomainModule
import com.geeks.episode.ui.di.episodeUiModule
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
                dataModule, domainModule, networkModule, uiModule,
                episodeDataModule, episodeDomainModule, episodeUiModule
            )
        }
    }

}