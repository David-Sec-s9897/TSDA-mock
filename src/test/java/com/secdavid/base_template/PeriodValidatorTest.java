package com.secdavid.base_template;

import com.secdavid.base_template.utils.PeriodValidator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PeriodValidatorTest {

  @ParameterizedTest
  @ValueSource(strings = {"P2Y", "P3M", "P4W", "P5D", "P1Y2M3D", "P1Y2M3W4D", "P-1Y2M"})
  void testValidPeriods(String period) {
    boolean result = PeriodValidator.validate(period);
    assertTrue(result);
  }
}
