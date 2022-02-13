package com.bookish.fornight.core

import com.bookish.fornight.core.dispatchers.CoroutineDispatchers
import com.bookish.fornight.core_ui.navigator.Navigator
import org.koin.dsl.module

@JvmField
val coreModule = module {
  single<CoroutineDispatchers> { DefaultCoroutineDispatchers() }

  single<Navigator> { NavigatorImpl(add = get(), search = get()) }
}
