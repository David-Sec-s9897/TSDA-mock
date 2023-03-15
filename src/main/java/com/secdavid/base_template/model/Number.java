package com.secdavid.base_template.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

/**
 * This tsDocument model is forked of the other data model:  com.sg.util.generated.tsdocument.entsoe.data.tsda.model
 * <p/>
 * It provides another date adapter to marshal / unmarshal the objects. Use this model if you have problems with generating the valid dates
 */
@XmlType(name = "number", namespace = "")
public abstract class Number implements Serializable {

  private static final long serialVersionUID = 3418679211167996007L;

}
