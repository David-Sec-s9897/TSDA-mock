package com.secdavid.base_template.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * This tsDocument model is forked of the other data model:  com.sg.util.generated.tsdocument.entsoe.data.tsda.model
 * <p/>
 * It provides another date adapter to marshal / unmarshal the objects. Use this model if you have problems with generating the valid dates
 */
public class TimeSeriesElement implements Serializable {

  private static final long serialVersionUID = -907236733038090289L;

  protected String id;
  protected List<SeriesPeriod> period;
  private String key;
  private String name;
  private List<String> tags;
  private Map<String, String> attributes;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<SeriesPeriod> getPeriod() {
    return period;
  }

  public void setPeriod(List<SeriesPeriod> period) {
    this.period = period;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Map<String, String> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
  }

}