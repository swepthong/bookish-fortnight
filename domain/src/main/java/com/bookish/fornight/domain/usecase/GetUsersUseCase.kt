package com.bookish.fornight.domain.usecase

import arrow.core.Either
import com.bookish.fornight.domain.model.User
import com.bookish.fornight.domain.model.UserError
import com.bookish.fornight.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val userRepository: UserRepository) {
  operator fun invoke(): Flow<Either<UserError, List<User>>> = userRepository.getUsers()
}
