package com.secdavid.base_template.utils;

import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeriodValidator {

  public static final Logger LOGGER = Logger.getLogger(PeriodValidator.class.getName());

  /**
   * Method to validate if provided String is valid from java.time.Period()
   *
   * @param strPeriod to validate
   * @return true if strPeriod is valid text value otherwise return false
   */
  public static boolean validate(String strPeriod) {
    return parsePeriod(strPeriod).isPresent();
  }

  /**
   * Parse period in string to java.time.Period()
   *
   * @param strPeriod based on the ISO-8601 period formats
   * @return java.time.Period() or null if  text cannot be parsed to a period;
   */
  public static Optional<Period> parsePeriod(String strPeriod) {
    Optional<Period> period = Optional.empty();
    try {
      period = Optional.of(Period.parse(strPeriod));
    } catch (DateTimeParseException e) {
      LOGGER.log(Level.SEVERE, "Could not parse period : " + strPeriod, e);
    } finally {
      return period;
    }
  }

}
