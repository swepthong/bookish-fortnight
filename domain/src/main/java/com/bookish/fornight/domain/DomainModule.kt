package com.bookish.fornight.domain

import com.bookish.fornight.domain.usecase.AddUserUseCase
import com.bookish.fornight.domain.usecase.GetUsersUseCase
import com.bookish.fornight.domain.usecase.RefreshGetUsersUseCase
import com.bookish.fornight.domain.usecase.RemoveUserUseCase
import com.bookish.fornight.domain.usecase.SearchUsersUseCase
import org.koin.dsl.module

@JvmField
val domainModule = module {
  factory { GetUsersUseCase(userRepository = get()) }

  factory { RefreshGetUsersUseCase(userRepository = get()) }

  factory { RemoveUserUseCase(userRepository = get()) }

  factory { AddUserUseCase(userRepository = get()) }

  factory { SearchUsersUseCase(userRepository = get()) }
}
