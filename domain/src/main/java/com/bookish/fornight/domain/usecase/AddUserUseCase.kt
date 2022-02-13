package com.bookish.fornight.domain.usecase

import arrow.core.Either
import com.bookish.fornight.domain.model.User
import com.bookish.fornight.domain.model.UserError
import com.bookish.fornight.domain.repository.UserRepository

class AddUserUseCase(private val userRepository: UserRepository) {
  suspend operator fun invoke(user: User): Either<UserError, Unit> = userRepository.add(user)
}
