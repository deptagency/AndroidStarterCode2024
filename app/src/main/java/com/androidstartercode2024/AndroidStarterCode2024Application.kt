package com.androidstartercode2024

import android.app.Application
import com.androidstartercode2024.utils.di.apiModule
import com.androidstartercode2024.utils.di.databaseModule
import com.androidstartercode2024.utils.di.repositoryModule
import com.androidstartercode2024.utils.di.retrofitModule
import com.androidstartercode2024.utils.di.useCaseModule
import com.androidstartercode2024.utils.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidStarterCode2024Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AndroidStarterCode2024Application)
            modules(listOf(viewModelModule, repositoryModule, useCaseModule, apiModule, retrofitModule, databaseModule))
        }
    }
}