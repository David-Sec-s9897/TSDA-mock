package com.secdavid.base_template.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;

/**
 * This tsDocument model is forked of the other data model:  com.sg.util.generated.tsdocument.entsoe.data.tsda.model
 * <p/>
 * It provides another date adapter to marshal / unmarshal the objects. Use this model if you have problems with generating the valid dates
 */
@XmlType(name = "Series_Period", namespace = "", propOrder = {"timeInterval", "resolution", "point"})
public class SeriesPeriod implements Serializable {

    private static final long serialVersionUID = -7004582495123531219L;
    private TimeInterval timeInterval;
    private Duration resolution;
    private List<Point> point;

    /**
     * (no documentation provided)
     */
    @XmlElement(name = "timeInterval", namespace = "", required = true)
    public TimeInterval getTimeInterval() {
        return this.timeInterval;
    }

    /**
     * (no documentation provided)
     */
    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    /**
     * (no documentation provided)
     */
    @XmlElement(name = "resolution", namespace = "", required = true)
    public Duration getResolution() {
        return this.resolution;
    }

    /**
     * (no documentation provided)
     */
    public void setResolution(Duration resolution) {
        this.resolution = resolution;
    }

    /**
     * (no documentation provided)
     */
    @XmlElement(name = "point", namespace = "", required = true)
    public List<Point> getPoint() {
        return this.point;
    }

    /**
     * (no documentation provided)
     */
    public void setPoint(List<Point> point) {
        this.point = point;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((point == null) ? 0 : point.hashCode());
        result = prime * result
            + ((resolution == null) ? 0 : resolution.hashCode());
        result = prime * result
            + ((timeInterval == null) ? 0 : timeInterval.hashCode());
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
        SeriesPeriod other = (SeriesPeriod) obj;
        if (point == null) {
            if (other.point != null) {
                return false;
            }
        } else if (!point.equals(other.point)) {
            return false;
        }
        if (resolution == null) {
            if (other.resolution != null) {
                return false;
            }
        } else if (!resolution.equals(other.resolution)) {
            return false;
        }
        if (timeInterval == null) {
            if (other.timeInterval != null) {
                return false;
            }
        } else if (!timeInterval.equals(other.timeInterval)) {
            return false;
        }
        return true;
    }


}
