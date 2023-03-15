package com.secdavid.base_template.utils;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DurationValidator {

  public static final Logger LOGGER = Logger.getLogger(DurationValidator.class.getName());

  /**
   * Method to validate if provided String is valid java.time.Duration() ISO-8601 value;
   *
   * @param str to validate
   * @return true if strPeriod is valid text value otherwise return false
   */
  public static boolean validate(String str) {
    return parseDuration(str).isPresent();
  }

  /**
   * Parse text duration in string to java.time.Duration()
   *
   * @param str based on the ISO-8601 duration formats
   * @return java.time.Duration() or null if text cannot be parsed as a Duration;
   */
  public static Optional<Duration> parseDuration(String str) {
    Optional<Duration> period = Optional.empty();
    try {
      period = Optional.of(Duration.parse(str));
    } catch (DateTimeParseException e) {
      LOGGER.log(Level.SEVERE, "Could not parse duration : " + str, e);
    } finally {
      return period;
    }
  }

}
