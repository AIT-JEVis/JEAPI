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
package org.jevis.api;

import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * The JEVisAttribute is the initialize of an JEVisType. An JEVisAttribute is
 * allways unique under an JEVisObject. The attibute will be configured by its
 * JEVisType.
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisAttribute extends JEVisComponent, JEVisCommittable, Comparable<JEVisAttribute> {

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
     * @throws org.jevis.api.JEVisException
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
     * @param from
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
     * Create an new JEViSample for this attribute with the Input Unit.
     *
     * @param ts of the sample, null if now()
     * @param value
     * @return
     * @throws JEVisException
     */
    JEVisSample buildSample(DateTime ts, Object value) throws JEVisException;

    /**
     * Create an new JEViSample for this attribute in the given unit.
     *
     * @param ts of the sample, null if now()
     * @param value
     * @param unit
     * @return
     * @throws JEVisException
     */
    JEVisSample buildSample(DateTime ts, double value, JEVisUnit unit) throws JEVisException;

    /**
     * Create an new JEViSample for this attribute with an note.
     *
     * @param ts of the sample, null if now()
     * @param value
     * @param note
     * @return
     * @throws JEVisException
     */
    JEVisSample buildSample(DateTime ts, Object value, String note) throws JEVisException;

    /**
     * Create an new JEViSample for this attribute with an note in the the given
     * unit.
     *
     * @param ts of the sample, null if now()
     * @param value
     * @param note
     * @param unit
     * @return
     * @throws JEVisException
     */
    JEVisSample buildSample(DateTime ts, double value, String note, JEVisUnit unit) throws JEVisException;

    /**
     * Resive the lastest sample by date
     *
     * @return
     */
    JEVisSample getLatestSample();

    /**
     * Get the primitiv type of the samples
     *
     * @throws org.jevis.api.JEVisException
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
     * @throws org.jevis.api.JEVisException
     */
    boolean deleteAllSample() throws JEVisException;

    /**
     * Deletes all Samples from ">=" to "<=" a certain date
     *
     * @param from (>=)
     * @param to (<=)
     * @return
     * @throws org.jevis.api.JEVisException
     */
    boolean deleteSamplesBetween(DateTime from, DateTime to) throws JEVisException;

    /**
     * Returns the unit of this Attribute.
     *
     * @return
     * @throws JEVisException
     */
    JEVisUnit getDisplayUnit() throws JEVisException;

    /**
     * Set the unit of this attribute.
     *
     * @param unit
     * @throws JEVisException
     */
    void setDisplayUnit(JEVisUnit unit) throws JEVisException;

    /**
     * Returns the unit in which the data are stored in the datasource
     *
     * @return @throws JEVisException
     */
    JEVisUnit getInputUnit() throws JEVisException;

    /**
     * Set the Unit in which the data will be stored in the datasource
     *
     * @param unit
     * @throws JEVisException
     */
    void setInputUnit(JEVisUnit unit) throws JEVisException;

    /**
     * Returns the default sample rate for the enduser represenation
     *
     * @return
     */
    Period getDisplaySampleRate();

    /**
     * returns the sample rate in which the data are stored in the datasource
     *
     * @return
     */
    Period getInputSampleRate();

    /**
     * Set the sample rate for in whoich the data are stored in the datasource
     *
     * @param period
     */
    void setInputSampleRate(Period period);

    /**
     * default sample rate for the enduser represenation
     *
     * @param period
     */
    void setDisplaySampleRate(Period period);

    /**
     * Ceck if the Attribute is from the given JEVisType
     *
     * @param type the to check for
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
