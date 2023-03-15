package com.secdavid.base_template.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This tsDocument model is forked of the other data model:  com.sg.util.generated.tsdocument.entsoe.data.tsda.model
 * <p/>
 * It provides another date adapter to marshal / unmarshal the objects. Use this model if you have problems with generating the valid dates
 */
@XmlType(name = "TsDocument", namespace = "", propOrder = {"id", "periodTimeInterval", "revisionNumber", "timeSeries"})
@XmlRootElement(name = "tsDocument", namespace = "")
public class TsDocument implements Serializable {

  private static final long serialVersionUID = 801973176293882723L;
  private String id;
  private TimeInterval periodTimeInterval;
  private String revisionNumber;
  private List<TimeSeries> TimeSeries;

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "id", namespace = "", required = true)
  public String getId() {
    return this.id;
  }

  /**
   * (no documentation provided)
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "period.timeInterval", namespace = "", required = true)
  public TimeInterval getPeriodTimeInterval() {
    return this.periodTimeInterval;
  }

  /**
   * (no documentation provided)
   */
  public void setPeriodTimeInterval(TimeInterval periodTimeInterval) {
    this.periodTimeInterval = periodTimeInterval;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "revisionNumber", namespace = "", required = true)
  public String getRevisionNumber() {
    return this.revisionNumber;
  }

  /**
   * (no documentation provided)
   */
  public void setRevisionNumber(String revisionNumber) {
    this.revisionNumber = revisionNumber;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "timeSeries", namespace = "")
  public List<TimeSeries> getTimeSeries() {
    return this.TimeSeries;
  }

  /**
   * (no documentation provided)
   */
  public void setTimeSeries(List<TimeSeries> TimeSeries) {
    this.TimeSeries = TimeSeries;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((TimeSeries == null) ? 0 : TimeSeries.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime
        * result
        + ((periodTimeInterval == null) ? 0 : periodTimeInterval
        .hashCode());
    result = prime * result
        + ((revisionNumber == null) ? 0 : revisionNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    TsDocument other = (TsDocument) obj;
    if (TimeSeries == null) {
      if (other.TimeSeries != null) {
        return false;
      }
    } else if (!TimeSeries.equals(other.TimeSeries)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (periodTimeInterval == null) {
      if (other.periodTimeInterval != null) {
        return false;
      }
    } else if (!periodTimeInterval.equals(other.periodTimeInterval)) {
      return false;
    }
    if (revisionNumber == null) {
      if (other.revisionNumber != null) {
        return false;
      }
    } else if (!revisionNumber.equals(other.revisionNumber)) {
      return false;
    }
    return true;
  }


}
