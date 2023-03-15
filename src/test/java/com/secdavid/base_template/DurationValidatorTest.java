package com.secdavid.base_template;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.secdavid.base_template.utils.DurationValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DurationValidatorTest {

  @ParameterizedTest
  @ValueSource(strings = {"P3D", "P1D", "PT24H", "PT15M", "PT1.234S"})
  void testValidPeriods(String period) {
    boolean result = DurationValidator.validate(period);
    assertTrue(result);
  }

}
