package com.secdavid.base_template.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * This tsDocument model is forked of the other data model:  com.sg.util.generated.tsdocument.entsoe.data.tsda.model
 * <p/>
 * It provides another date adapter to marshal / unmarshal the objects. Use this model if you have problems with generating the valid dates
 */
@XmlType(name = "Point", namespace = "", propOrder = {"datumZeitUTC", "position", "quantity"})
public class Point implements Serializable {

  private static final long serialVersionUID = -3736215080018498285L;
  private XMLGregorianCalendar datumZeitUTC;
  private int position;
  private double quantity;

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "DatumZeitUTC", namespace = "")
  public XMLGregorianCalendar getDatumZeitUTC() {
    return this.datumZeitUTC;
  }

  /**
   * (no documentation provided)
   */
  public void setDatumZeitUTC(XMLGregorianCalendar datumZeitUTC) {
    this.datumZeitUTC = datumZeitUTC;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "position", namespace = "")
  public int getPosition() {
    return this.position;
  }

  /**
   * (no documentation provided)
   */
  public void setPosition(int position) {
    this.position = position;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "quantity", namespace = "", required = true)
  public double getQuantity() {
    return this.quantity;
  }

  /**
   * (no documentation provided)
   */
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((datumZeitUTC == null) ? 0 : datumZeitUTC.hashCode());
    result = prime * result + position;
    long temp;
    temp = Double.doubleToLongBits(quantity);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    Point other = (Point) obj;
    if (datumZeitUTC == null) {
      if (other.datumZeitUTC != null) {
        return false;
      }
    } else if (!datumZeitUTC.equals(other.datumZeitUTC)) {
      return false;
    }
    if (position != other.position) {
      return false;
    }
    if (Double.doubleToLongBits(quantity) != Double
        .doubleToLongBits(other.quantity)) {
      return false;
    }
    return true;
  }


}
