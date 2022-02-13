package com.bookish.fornight.data.mapper

import com.bookish.fornight.data.remote.UserBody
import com.bookish.fornight.domain.model.User
import com.bookish.fornight.test_utils.valueOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals

class UserDomainToUserBodyMapperTest {
  private val mapper = UserDomainToUserBodyMapper()

  @Test
  fun test_UserDomainToUserBodyMapper() {
    val body = mapper(
      User.create(
        id = "id",
        email = "email@gmail.com",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      ).valueOrThrow
    )

    assertEquals(
      UserBody(
        email = "email@gmail.com",
        firstName = "first",
        lastName = "last",
      ),
      body
    )
  }
}
