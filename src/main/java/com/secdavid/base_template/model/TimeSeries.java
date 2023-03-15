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
@XmlType(name = "TimeSeries", namespace = "", propOrder = {"id", "period", "key", "name", "tags", "attributes"})
@XmlRootElement(name = "TimeSeries", namespace = "")
public class TimeSeries implements Serializable {

  private static final long serialVersionUID = -4755750147511790393L;
  private String id;
  private List<SeriesPeriod> period;
  private String key;
  private String name;
  private List<String> tags;
  private Object attributes;

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
  @XmlElement(name = "period", namespace = "", required = true)
  public List<SeriesPeriod> getPeriod() {
    return this.period;
  }

  /**
   * (no documentation provided)
   */
  public void setPeriod(List<SeriesPeriod> period) {
    this.period = period;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "key", namespace = "", required = true)
  public String getKey() {
    return this.key;
  }

  /**
   * (no documentation provided)
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "name", namespace = "", required = true)
  public String getName() {
    return this.name;
  }

  /**
   * (no documentation provided)
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * (no documentation provided)
   */
  @XmlElement(name = "tags", namespace = "", required = true)
  public List<String> getTags() {
    return this.tags;
  }

  /**
   * (no documentation provided)
   */
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * (no documentation provided)
   */
  public Object getAttributes() {
    return this.attributes;
  }

  /**
   * (no documentation provided)
   */
  public void setAttributes(Object attributes) {
    this.attributes = attributes;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((attributes == null) ? 0 : attributes.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((period == null) ? 0 : period.hashCode());
    result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
    TimeSeries other = (TimeSeries) obj;
    if (attributes == null) {
      if (other.attributes != null) {
        return false;
      }
    } else if (!attributes.equals(other.attributes)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (key == null) {
      if (other.key != null) {
        return false;
      }
    } else if (!key.equals(other.key)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (period == null) {
      if (other.period != null) {
        return false;
      }
    } else if (!period.equals(other.period)) {
      return false;
    }
    if (tags == null) {
      if (other.tags != null) {
        return false;
      }
    } else if (!tags.equals(other.tags)) {
      return false;
    }
    return true;
  }


}
