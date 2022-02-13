package com.bookish.fornight.test_utils

import com.bookish.fornight.core.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher

@ExperimentalCoroutinesApi
class TestDispatchers(testCoroutineDispatcher: TestDispatcher) :
  CoroutineDispatchers {
  override val main: CoroutineDispatcher = testCoroutineDispatcher
  override val io: CoroutineDispatcher = testCoroutineDispatcher
}
