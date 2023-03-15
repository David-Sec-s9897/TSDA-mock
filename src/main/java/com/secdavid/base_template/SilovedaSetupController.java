package com.secdavid.base_template;

import com.secdavid.base_template.model.SilovedaProcess;
import com.secdavid.base_template.services.SilovedaConfigurationService;
import com.secdavid.base_template.services.TsDocumentService;
import com.secdavid.base_template.utils.DurationValidator;
import com.secdavid.base_template.utils.PeriodValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setup/")
public class SilovedaSetupController {

  @Autowired
  SilovedaConfigurationService silovedaService;


  @Autowired
  TsDocumentService tsDocumentService;

  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<SilovedaProcess> listAll() {
    return silovedaService.listAll();
  }

  @PostMapping(value = "/add/{siloId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<SilovedaProcess> setConfiguration(@PathVariable("siloId") String siloId, @RequestBody SilovedaProcess silovedaProcess) {
    if (isValidResolution(silovedaProcess.getResolution())) {
      silovedaService.add(new SilovedaProcess(siloId, silovedaProcess.getResolution()));
    }
    return silovedaService.listAll();
  }

  @PostMapping(value = "/setupMultiple", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<SilovedaProcess> setConfiguration(@RequestBody List<SilovedaProcess> silovedaProcesses) {
    silovedaProcesses.forEach(silovedaProcess -> {
      if (isValidResolution(silovedaProcess.getResolution())) {
        silovedaService.add(silovedaProcess);
      }
    });
    return silovedaService.listAll();
  }

  @PostMapping(value = "/delete/{siloId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<SilovedaProcess> setConfiguration(@PathVariable("siloId") String siloId) {
    silovedaService.delete(siloId);
    return silovedaService.listAll();
  }

  private boolean isValidResolution(String resolution) {
    return DurationValidator.validate(resolution);
  }


}
