/**
 * Copyright (C) 2013 - 2014 Envidatec GmbH <info@envidatec.com>
 *
 * This file is part of JEAPI.
 *
 * JEAPI is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation in version 3.
 *
 * JEAPI is distributed in the hope that it will be useful, but WITHOUT ANY
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

import java.util.List;
import javax.measure.unit.Unit;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * The JEVisAttribute is the initialize JEVis Type. An JEVisAttribute is allways
 * unique under an JEVisObject. The Aiitibute will be configured by its
 * JEVisType.
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisAttribute extends JEVisComponent, Comparable<JEVisAttribute> {

    /**
     * Get the Name of the Attribute.The Name is uniqu under this JEVisObject
     *
     * @return
     */
    String getName();

    /**
     * Delte this object and remove all reference to it.
     *
     * @return
     */
    boolean delete();

    /**
     * Get the JEVisType of this Attribute
     *
     * @return
     */
    JEVisType getType() throws JEVisException;

    /**
     * Get the JEVisObject this attribute belongs to
     *
     * @return
     */
    JEVisObject getObject();

    /**
     * resive all samples the attribute may hold
     *
     * @return
     */
    List<JEVisSample> getAllSamples();

    /**
     * Resive all Samplaes from ">=" to "<=" a certain date @param fro
     *
     * m (>=)
     *
     * @param to (<=)
     *
     * @return
     */
    List<JEVisSample> getSamples(DateTime from, DateTime to);

    /**
     * Add and commit all samples
     *
     * @param samples
     * @return
     * @throws JEVisException
     */
    int addSamples(List<JEVisSample> samples) throws JEVisException;

    /**
     *
     * @param timestamp of the sample, null if now()
     * @param value
     * @return
     * @throws JEVisException
     */
    JEVisSample buildSample(DateTime ts, Object value) throws JEVisException;

    /**
     *
     * @param timestamp of the sample, null if now()
     * @param value
     * @param note
     * @return
     * @throws JEVisException
     */
    JEVisSample buildSample(DateTime ts, Object value, String note) throws JEVisException;

    /**
     * Resive the lastest sample by date
     *
     * @return
     */
    JEVisSample getLatestSample();

    /**
     * Get the primitiv type of the samples
     *
     * @see org.jevis.jeapi.JEVisConstants.PrimitiveType
     *
     * @return
     */
    int getPrimitiveType() throws JEVisException;

    /**
     * Returns true if the attribute holds anay samples
     *
     * @return
     */
    boolean hasSample();

    /**
     * Get the Timestamp from the first sample of the attribute
     *
     * @return
     */
    DateTime getTimestampFromFirstSample();

    /**
     * Get the last Timetsmap of the attribute
     *
     * @return
     */
    DateTime getTimestampFromLastSample();

    /**
     * Delete all samples this attribute may holds
     *
     * @return
     */
    boolean deleteAllSample() throws JEVisException;

    /**
     * Deletes all Samples from ">=" to "<=" a certain date
     *
     * @param from (>=)
     * @param to (<=)
     * @return
     */
    boolean deleteSamplesBetween(DateTime from, DateTime to) throws JEVisException;

    Unit getUnit() throws JEVisException;

    void setUnit(Unit unit) throws JEVisException;

    /**
     * Get the Alternativ Sybol for the Unit of this type
     *
     * @return
     * @throws JEVisException
     */
    String getAlternativSymbol() throws JEVisException;

    /**
     * Set an alternative sybols for the unit of theis tpye
     *
     * @param symbol
     * @return
     * @throws JEVisException
     */
    void setAlternativSymbol(String symbol) throws JEVisException;

    //PeriodFormatter format = ISOPeriodFormat.standard();
    //format.parsePeriod(startText);
    /**
     * Period of the samples as ISO-8601 for example "P15m" are 15 minutes
     *
     * @return
     */
    Period getPeriod();

    /**
     * Ceck if the Attribute is from the given JEVisType
     *
     * @param JEVisType the to check for
     * @return
     */
    boolean isType(JEVisType type);

    /**
     * Get the count of all samples allocated to this attribute
     *
     * @return
     */
    long getSampleCount();

}
