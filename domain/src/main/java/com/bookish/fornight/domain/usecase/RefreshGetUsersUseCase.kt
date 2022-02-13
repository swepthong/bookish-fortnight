package com.bookish.fornight.domain.usecase

import arrow.core.Either
import com.bookish.fornight.domain.model.UserError
import com.bookish.fornight.domain.repository.UserRepository

class RefreshGetUsersUseCase(private val userRepository: UserRepository) {
  suspend operator fun invoke(): Either<UserError, Unit> = userRepository.refresh()
}
