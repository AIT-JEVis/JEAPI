/**
 * Copyright (C) 2013 - 2013 Envidatec GmbH <info@envidatec.com>
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
    DateTime getTimestamp();

    /**
     * Returns the sample's value
     *
     * @return value of generic type T
     */
    Object getValue();

    String getValueAsString();

    Long getValueAsLong();

    Double getValueAsDouble();

    Boolean getValueAsBoolean();

    JEVisFile getValueAsFile();

    JEVisSelection getValueAsSelection();

    JEVisMultiSelection getValueAsMultiSelection();

    /**
     * Set the value of this sample.
     *
     * @param value can be()
     * @throws ClassCastException
     */
    void setValue(Object value) throws ClassCastException;

    /**
     *
     * @return
     */
//    JEVisManipulation getManipulation(); 
    JEVisAttribute getAttribute();

    /**
     * An human readable note for this sample.
     *
     * @return
     */
    String getNote();

    /**
     * Set the human readable note for thi sample
     *
     * @param note
     */
    void setNote(String note);
}
