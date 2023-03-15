package com.secdavid.base_template.services;

import com.secdavid.base_template.model.SilovedaProcess;
import jakarta.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SilovedaConfigurationService {

  Set<SilovedaProcess> processConfiguration;

  @PostConstruct
  public void init() {
    processConfiguration = new HashSet<>();

  }

  public List<SilovedaProcess> listAll() {
    return processConfiguration.stream().collect(Collectors.toList());
  }

  public void add(SilovedaProcess silovedaProcess) {
    processConfiguration.add(silovedaProcess);
  }

  public SilovedaProcess update(SilovedaProcess silovedaProcess) {
    SilovedaProcess processToUpdate = find(silovedaProcess.getSilovedaId());
    if (processToUpdate != null) {
      updateProcessData(processToUpdate, silovedaProcess);
    }
    return processToUpdate;
  }

  public void delete(String siloId) {
    SilovedaProcess processToDelete = find(siloId);
    if (processToDelete != null) {
      processConfiguration.remove(processToDelete);
    }
  }

  public SilovedaProcess find(String siloId) {
    return processConfiguration.stream().filter(silovedaProcess -> silovedaProcess.getSilovedaId().equalsIgnoreCase(siloId)).findFirst().orElse(null);
  }

  private void updateProcessData(SilovedaProcess processToUpdate, SilovedaProcess silovedaProcess) {
    processToUpdate.setResolution(silovedaProcess.getResolution());
  }
}
