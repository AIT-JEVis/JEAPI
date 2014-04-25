/**
 * Copyright (C) 2013 - 2014 Envidatec GmbH <info@envidatec.com>
 *
 * This file is part of JEAPI.
 *
 * JAPI is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation in version 3.
 *
 * JAPI is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * JEAPI. If not, see <http://www.gnu.org/licenses/>.
 *
 * JEAPI is part of the OpenJEVis project, further project information are
 * published at <http://www.OpenJEVis.org/>.
 */
package org.jevis.jeapi;

import javax.measure.unit.Unit;
import org.joda.time.DateTime;

/**
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisSample extends JEVisComponent, JEVisCommittable {

    /**
     * Returns the sample's timestamp
     *
     * @return JevCalendar timestamp
     */
    DateTime getTimestamp() throws JEVisException;

    /**
     * Returns the sample's value
     *
     * @return value of generic type T
     */
    Object getValue() throws JEVisException;

    String getValueAsString() throws JEVisException;

    Long getValueAsLong() throws JEVisException;

    Long getValueAsLong(Unit unit) throws JEVisException;

    Double getValueAsDouble() throws JEVisException;

    Double getValueAsDouble(Unit unit) throws JEVisException;

    Boolean getValueAsBoolean() throws JEVisException;

    JEVisFile getValueAsFile() throws JEVisException;

    JEVisSelection getValueAsSelection() throws JEVisException;

    JEVisMultiSelection getValueAsMultiSelection() throws JEVisException;

    /**
     * Set the value of this sample. The value has to be in default unit of the
     * attribute
     *
     * @param value can be()
     * @throws ClassCastException
     */
    void setValue(Object value) throws JEVisException, ClassCastException;

    /**
     * Set the value of this samplein the given unit. The JEVisSample will try
     * to convert the value to the daukt value for storage.
     *
     * @param value
     * @param unit
     */
    void setValue(Object value, Unit unit) throws JEVisException, ClassCastException;

    /**
     *
     * @return
     */
//    JEVisManipulation getManipulation(); 
    JEVisAttribute getAttribute() throws JEVisException;

    /**
     * An human readable note for this sample.
     *
     * @return
     */
    String getNote() throws JEVisException;

    /**
     * Set the human readable note for thi sample
     *
     * @param note
     */
    void setNote(String note) throws JEVisException;

    /**
     * Get the unit of sample
     *
     * @return
     * @throws JEVisException
     */
    public Unit getUnit() throws JEVisException;
}
