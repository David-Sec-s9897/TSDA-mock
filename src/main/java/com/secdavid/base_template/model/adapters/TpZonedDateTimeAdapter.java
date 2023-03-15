package com.secdavid.base_template.model.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

public class TpZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {

  private static final Logger LOGGER = Logger.getLogger(TpZonedDateTimeAdapter.class.getName());

  private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmz");
  private DateTimeFormatter secondDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz'");
  private DateTimeFormatter thirdDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy'T'HH:mm:ssz");

  /**
   * {@inheritDoc}
   */
  @Override
  public String marshal(ZonedDateTime zonedDateTime) {

    dateFormat.withZone(ZoneId.of("UTC"));
    return dateFormat.format(zonedDateTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ZonedDateTime unmarshal(String date) {
    ZonedDateTime parsedDate = tryAndParse(dateFormat, date);
    if (parsedDate == null) {
      parsedDate = tryAndParse(secondDateFormat, date);
    }
    if (parsedDate == null) {
      parsedDate = tryAndParse(thirdDateFormat, date);
    }

    if (parsedDate == null) {
      LOGGER.log(Level.SEVERE, "The date '" + date + "' cannot be parsed. ");
      return null;
    } else {
      return parsedDate;
    }
  }

  private ZonedDateTime tryAndParse(DateTimeFormatter formatter, String date) {
    try {
      TimeZone ts = TimeZone.getTimeZone("UTC");
      return ZonedDateTime.parse(date, formatter);
    } catch (DateTimeParseException e) {
      LOGGER.log(Level.WARNING, "Unparsable date: " + date, e);
      return null;
    }
  }
}
