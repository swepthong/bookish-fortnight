package com.bookish.fornight.data.mapper

import com.bookish.fornight.data.remote.UserResponse
import com.bookish.fornight.domain.model.User
import com.bookish.fornight.domain.model.UserValidationError
import com.bookish.fornight.test_utils.invalidValueOrThrow
import com.bookish.fornight.test_utils.valueOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserResponseToUserDomainMapperTest {
  private val mapper = UserResponseToUserDomainMapper()

  @Test
  fun testUserDomainToUserResponseMapper_withValidResponse_returnsValid() {
    val validated = mapper(
      UserResponse(
        id = "id",
        email = "email@gmail.com",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      )
    )
    assertTrue(validated.isValid)
    assertEquals(
      User.create(
        id = "id",
        email = "email@gmail.com",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      ).valueOrThrow,
      validated.valueOrThrow,
    )
  }

  @Test
  fun testUserDomainToUserResponseMapper_withInvalidResponse_returnsInvalid() {
    val validated = mapper(
      UserResponse(
        id = "id",
        email = "email@",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      )
    )
    assertTrue(validated.isInvalid)
    assertEquals(
      UserValidationError.INVALID_EMAIL_ADDRESS,
      validated.invalidValueOrThrow.head,
    )
  }
}
