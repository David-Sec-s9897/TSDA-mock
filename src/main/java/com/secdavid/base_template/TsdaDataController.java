package com.secdavid.base_template;

import com.secdavid.base_template.exception.InvalidDateFormatException;
import com.secdavid.base_template.model.TsDocument;
import com.secdavid.base_template.services.TsDocumentService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.datatype.DatatypeConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/rest/data/")
public class TsdaDataController {

  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");


  @Autowired
  TsDocumentService tsDocumentService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "id/{siloId}", produces = MediaType.APPLICATION_XML_VALUE)
  public String sayHello(@PathVariable("siloId") String siloId, @RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("boundary") String boundary)
          throws DatatypeConfigurationException {

    format.setTimeZone(TimeZone.getTimeZone("UTC"));
    try {
      Date startDate = format.parse(start);
      Date endDate = format.parse(end);

      TsDocument tsDocument1 = tsDocumentService.generateBasicDocumentTemplate(siloId)
              .setIntervals(startDate, endDate).generateTimeSeries().build();
      OutputStream outputStream = new ByteArrayOutputStream();
      JAXB.marshal(tsDocument1, outputStream);

      return outputStream.toString();
    } catch (ParseException e) {
      throw new InvalidDateFormatException("Invalid start or end DateTime format.", e);
    }
  }

}
