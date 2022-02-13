package com.bookish.fornight.data.mapper

import arrow.core.ValidatedNel
import com.bookish.fornight.core.Mapper
import com.bookish.fornight.data.remote.UserResponse
import com.bookish.fornight.domain.model.User
import com.bookish.fornight.domain.model.UserValidationError

internal class UserResponseToUserDomainMapper : Mapper<UserResponse, ValidatedNel<UserValidationError, User>> {
  override fun invoke(response: UserResponse): ValidatedNel<UserValidationError, User> {
    return User.create(
      id = response.id,
      avatar = response.avatar,
      email = response.email,
      firstName = response.firstName,
      lastName = response.lastName
    )
  }
}
