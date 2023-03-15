package com.secdavid.base_template.model.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TpDateAdapter extends XmlAdapter<String, Date> {

  private static final Logger LOGGER = Logger.getLogger(TpDateAdapter.class.getName());

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
  private SimpleDateFormat secondDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
  private SimpleDateFormat thirdDateFormat = new SimpleDateFormat("dd.MM.yyyy'T'HH:mm:ss");

  /**
   * {@inheritDoc}
   */
  @Override
  public String marshal(Date date) {

    TimeZone ts = TimeZone.getTimeZone("UTC");
    dateFormat.setTimeZone(ts);
    return dateFormat.format(date);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Date unmarshal(String date) {
    Date parsedDate = tryAndParse(dateFormat, date);
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

  private Date tryAndParse(SimpleDateFormat sdf, String date) {
    try {
      TimeZone ts = TimeZone.getTimeZone("UTC");
      sdf.setTimeZone(ts);
      return sdf.parse(date);
    } catch (ParseException e) {
      LOGGER.log(Level.WARNING, "Unparsable date: " + date, e);
      return null;
    }
  }
}
