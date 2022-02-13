package com.bookish.fornight.domain.model

import arrow.core.ValidatedNel

@JvmInline
value class FirstName private constructor(val value: String) {
  companion object {
    fun create(value: String?): ValidatedNel<UserValidationError, FirstName> =
      validateFirstName(value).map(::FirstName)
  }
}
