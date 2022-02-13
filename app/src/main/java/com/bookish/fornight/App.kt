package com.bookish.fornight

import android.app.Application
import com.google.android.material.color.DynamicColors
import com.bookish.fornight.core.coreModule
import com.bookish.fornight.data.dataModule
import com.bookish.fornight.domain.domainModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import kotlin.time.ExperimentalTime

@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
@ExperimentalTime
@JvmField
val allModules = listOf(
  coreModule,
  dataModule,
  domainModule
)

@Suppress("unused")
@ExperimentalStdlibApi
@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalTime
class App : Application() {
  override fun onCreate() {
    super.onCreate()

    DynamicColors.applyToActivitiesIfAvailable(this)

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    } else {
      // TODO(Timber): plant release tree
    }

    startKoin {
      androidContext(this@App)

      // TODO(koin): https://github.com/InsertKoinIO/koin/issues/1188
      androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)

      modules(allModules)
    }
  }
}
