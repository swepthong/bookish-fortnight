package com.bookish.fornight.data.mapper

import com.bookish.fornight.core.Mapper
import com.bookish.fornight.data.remote.UserBody
import com.bookish.fornight.domain.model.User

internal class UserDomainToUserBodyMapper : Mapper<User, UserBody> {
  override fun invoke(domain: User): UserBody {
    return UserBody(
      email = domain.email.value,
      firstName = domain.firstName.value,
      lastName = domain.lastName.value
    )
  }
}
