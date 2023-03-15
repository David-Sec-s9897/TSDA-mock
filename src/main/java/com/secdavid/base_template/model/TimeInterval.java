package com.secdavid.base_template.model;

import com.secdavid.base_template.model.adapters.TpDateAdapter;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * This tsDocument model is forked of the other data model:  com.sg.util.generated.tsdocument.entsoe.data.tsda.model
 * <p/>
 * It provides another date adapter to marshal / unmarshal the objects. Use this model if you have problems with generating the valid dates
 */
@XmlType(name = "ESMP_DateTimeInterval", namespace = "", propOrder = {"start", "end"})
public class TimeInterval implements Serializable {

  private static final long serialVersionUID = -6081055264870646004L;
  private Date start;
  private Date end;

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "start", namespace = "", required = true)
  @XmlJavaTypeAdapter(TpDateAdapter.class)
  public Date getStart() {
    return this.start;
  }

  /**
   * (no documentation provided)
   */
  public void setStart(Date start) {
    this.start = start;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "end", namespace = "", required = true)
  @XmlJavaTypeAdapter(TpDateAdapter.class)
  public Date getEnd() {
    return this.end;
  }

  /**
   * (no documentation provided)
   */
  public void setEnd(Date end) {
    this.end = end;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((end == null) ? 0 : end.hashCode());
    result = prime * result + ((start == null) ? 0 : start.hashCode());
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
    TimeInterval other = (TimeInterval) obj;
    if (end == null) {
      if (other.end != null) {
        return false;
      }
    } else if (!end.equals(other.end)) {
      return false;
    }
    if (start == null) {
      if (other.start != null) {
        return false;
      }
    } else if (!start.equals(other.start)) {
      return false;
    }
    return true;
  }


}
