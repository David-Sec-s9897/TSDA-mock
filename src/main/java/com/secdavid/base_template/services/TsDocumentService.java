package com.secdavid.base_template.services;

import com.secdavid.base_template.model.Point;
import com.secdavid.base_template.model.SilovedaProcess;
import com.secdavid.base_template.model.TsDocument;
import com.secdavid.base_template.utils.DurationValidator;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TsDocumentService {

  @Autowired
  SilovedaConfigurationService configurationService;

  private TsDocument loadedDocument;
  private TsDocument tsDocument;


  public TsDocumentService generateBasicDocumentTemplate(String siloId) throws DatatypeConfigurationException {
    this.tsDocument = generateBasicDocumentTemplate();
    tsDocument.getTimeSeries().get(0).setId(siloId);
    SilovedaProcess silovedaProcess = configurationService.find(siloId);
    if (silovedaProcess != null && silovedaProcess.getResolution() != null) {
      tsDocument.getTimeSeries().get(0).getPeriod().get(0).setResolution(DatatypeFactory.newInstance().newDuration(silovedaProcess.getResolution()));
    }
    return this;
  }


  private TsDocument loadDocumentFromXML() throws JAXBException, FileNotFoundException {
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("tsDocument.xml");
    TsDocument tsDocument = JAXB.unmarshal(inputStream, com.secdavid.base_template.model.TsDocument.class);
    return tsDocument;
  }

  private TsDocument generateBasicDocumentTemplate() {
    if (loadedDocument == null) {
      try {
        loadedDocument = loadDocumentFromXML();
      } catch (JAXBException | FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return loadedDocument;
  }

  public TsDocumentService setIntervals(Date startDate, Date endDate) {
    tsDocument.getPeriodTimeInterval().setStart(startDate);
    tsDocument.getPeriodTimeInterval().setEnd(endDate);
    tsDocument.getTimeSeries().get(0).getPeriod().get(0).getTimeInterval().setStart(startDate);
    tsDocument.getTimeSeries().get(0).getPeriod().get(0).getTimeInterval().setEnd(endDate);
    return this;
  }

  public TsDocumentService setResolution(Duration duration) throws DatatypeConfigurationException {
    tsDocument.getTimeSeries().get(0).getPeriod().get(0).setResolution(DatatypeFactory.newInstance().newDuration(duration.toString()));
    return this;
  }

  public TsDocumentService generateTimeSeries() throws DatatypeConfigurationException {

    Duration parse = Duration.parse(tsDocument.getTimeSeries().get(0).getPeriod().get(0).getResolution().toString());

    ZonedDateTime startDateTime = ZonedDateTime.ofInstant(tsDocument.getPeriodTimeInterval().getStart().toInstant(), ZoneId.of("UTC"));
    ZonedDateTime endDateTime = ZonedDateTime.ofInstant(tsDocument.getPeriodTimeInterval().getEnd().toInstant(), ZoneId.of("UTC"));

    Duration duration2 = Duration.between(startDateTime, endDateTime);

    long numberOfIntervals = duration2.getSeconds() / parse.getSeconds();

    List<Point> points = tsDocument.getTimeSeries().get(0).getPeriod().get(0).getPoint();
    points.clear();

    int i = 0;
    while (!(startDateTime.plus(parse.multipliedBy(i)).isEqual(endDateTime) || startDateTime.plus(parse.multipliedBy(i)).isAfter(endDateTime))) {
      Point p = new Point();
      p.setPosition(i + 1);
      p.setQuantity(0.d);
      GregorianCalendar cal = GregorianCalendar.from(startDateTime.plus(parse.multipliedBy(i)));
      cal.setTimeZone(TimeZone.getTimeZone("UTC"));

      p.setDatumZeitUTC(DatatypeFactory
          .newInstance()
          .newXMLGregorianCalendar(startDateTime.plus(parse.multipliedBy(i)).format(DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss"))));
      points.add(p);
      ++i;
    }
    System.out.println("number of datapoints: " + i + " vs " + numberOfIntervals);
    return this;
  }

  public TsDocument build() {
    return tsDocument;
  }


  public class TsDocumentBuilder {

    TsDocument tsDocument;
  }
}
