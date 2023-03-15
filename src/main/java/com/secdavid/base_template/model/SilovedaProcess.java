package com.secdavid.base_template.model;

public class SilovedaProcess {

  String silovedaId;
  String resolution;

  public SilovedaProcess(String silovedaId, String resolution) {
    this.silovedaId = silovedaId;
    this.resolution = resolution;
  }

  public String getSilovedaId() {
    return silovedaId;
  }

  public void setSilovedaId(String silovedaId) {
    this.silovedaId = silovedaId;
  }

  public String getResolution() {
    return resolution;
  }

  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  @Override
  public String toString() {
    return "SilovedaProcess{" +
        "silovedaId='" + silovedaId + '\'' +
        ", resolution='" + resolution + '\'' +
        '}';
  }
}
