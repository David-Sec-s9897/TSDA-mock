package com.secdavid.base_template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DummyTest {

  @Test
  void someDummyTest() {
    Assertions.assertEquals(true, 1 == 1);
  }

  @ParameterizedTest
  @ValueSource(ints = {-5, -3, 1, 3, 5, 15, Integer.MAX_VALUE})
  void SomeDummyParametrizedTest(int number) {
    Assertions.assertNotEquals(true, number % 2 == 0);
  }
}
