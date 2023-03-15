package com.secdavid.base_template.model;

/**
 * This tsDocument model is forked of the other data model:  com.sg.util.generated.tsdocument.entsoe.data.tsda.model
 * <p/>
 * It provides another date adapter to marshal / unmarshal the objects. Use this model if you have problems with generating the valid dates
 */
public class Attributes {

  private String zeitreihemasseinheit;
  private String abfragetyp;
  private Object abfragecode;
  private String zeitreihereihe;
  private String abfragebeschreibung;
  private String zeitreihekennzahl;
  private String abfragename;
  private String datenquelle;
  private String datenausgerollt;

  public String getZeitreihemasseinheit() {
    return zeitreihemasseinheit;
  }

  public void setZeitreihemasseinheit(String zeitreihemasseinheit) {
    this.zeitreihemasseinheit = zeitreihemasseinheit;
  }

  public String getAbfragetyp() {
    return abfragetyp;
  }

  public void setAbfragetyp(String abfragetyp) {
    this.abfragetyp = abfragetyp;
  }

  public Object getAbfragecode() {
    return abfragecode;
  }

  public void setAbfragecode(Object abfragecode) {
    this.abfragecode = abfragecode;
  }

  public String getZeitreihereihe() {
    return zeitreihereihe;
  }

  public void setZeitreihereihe(String zeitreihereihe) {
    this.zeitreihereihe = zeitreihereihe;
  }

  public String getAbfragebeschreibung() {
    return abfragebeschreibung;
  }

  public void setAbfragebeschreibung(String abfragebeschreibung) {
    this.abfragebeschreibung = abfragebeschreibung;
  }

  public String getZeitreihekennzahl() {
    return zeitreihekennzahl;
  }

  public void setZeitreihekennzahl(String zeitreihekennzahl) {
    this.zeitreihekennzahl = zeitreihekennzahl;
  }

  public String getAbfragename() {
    return abfragename;
  }

  public void setAbfragename(String abfragename) {
    this.abfragename = abfragename;
  }

  public String getDatenquelle() {
    return datenquelle;
  }

  public void setDatenquelle(String datenquelle) {
    this.datenquelle = datenquelle;
  }

  public String getDatenausgerollt() {
    return datenausgerollt;
  }

  public void setDatenausgerollt(String datenausgerollt) {
    this.datenausgerollt = datenausgerollt;
  }

}