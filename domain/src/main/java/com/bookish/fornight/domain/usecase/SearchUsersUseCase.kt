package com.bookish.fornight.domain.usecase

import arrow.core.Either
import com.bookish.fornight.domain.model.User
import com.bookish.fornight.domain.model.UserError
import com.bookish.fornight.domain.repository.UserRepository

class SearchUsersUseCase(private val userRepository: UserRepository) {
  suspend operator fun invoke(query: String): Either<UserError, List<User>> =
    userRepository.search(query)
}
