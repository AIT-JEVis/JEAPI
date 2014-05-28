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

import javax.measure.unit.Unit;

/**
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisType extends JEVisComponent, JEVisCommittable, Comparable<JEVisType> {

    /**
     * Returns the name of this type. The name is an unique identifier for an
     * type. The name does not have to be unique in the JEVis system but has to
     * be under an JEVisClass.
     *
     * @return
     * @throws JEVisException
     */
    String getName() throws JEVisException;

    /**
     * Set the name for this type. The name is an unique identifier for an type.
     * The name does not have to be unique in the JEVis system but has to be
     * under an JEVisClass.
     *
     * @param name
     * @throws JEVisException
     */
    void setName(String name) throws JEVisException;

    /**
     * Returns the primitive type.
     *
     * @see JEVisConstants
     * @return
     * @throws JEVisException
     */
    int getPrimitiveType() throws JEVisException;

    /**
     * Set the primitiv type.
     *
     * @see JEVisConstants
     * @param type
     * @throws JEVisException
     */
    void setPrimitiveType(int type) throws JEVisException;

    /**
     * Retuns the GUI display type. GUIs will use this type to display the
     * value, for example an String could displayed as asterisk textfild or
     * clear text.
     *
     * @return
     * @throws JEVisException
     */
    String getGUIDisplayType() throws JEVisException;

    /**
     * Set the GUI display type.
     *
     * @see JEVisConstants
     * @param type
     * @throws JEVisException
     */
    void setGUIDisplayType(String type) throws JEVisException;

    /**
     * Set the order of the input field for this type in the GUI. The Fields
     * will be sorted from lowest-top to the highst-bottom.
     *
     * @param pos
     * @throws JEVisException
     */
    void setGUIPosition(int pos) throws JEVisException;

    /**
     * Returns postions of this type in the GUI. The Fields will be sorted from
     * lowest-top to the highst-bottom.
     *
     * @return
     * @throws JEVisException
     */
    int getGUIPosition() throws JEVisException;

    /**
     * returns the JEVisClass of this type.
     *
     * @return JEVisClass of this type
     * @throws JEVisException
     */
    JEVisClass getJEVisClass() throws JEVisException;

    /**
     * Returns the validity. The validity tells the api how to handel die
     * timestample. For example if only the last value is valid or if every
     * timestamps is vaild at this time.
     *
     * @see JEVisConstants
     * @return validity of the sample
     * @throws JEVisException
     */
    int getValidity() throws JEVisException;

    /**
     * Set the validity. The validity tells the api how to handel die
     * timestample. For example if only the last value is valid or if every
     * timestamps is vaild at this time.
     *
     * @see JEVisConstants
     * @param validity
     * @throws JEVisException
     */
    void setValidity(int validity) throws JEVisException;

    /**
     * Return the additional configuration parameter. This funtion is not in use
     * an will be changed?!
     *
     * @deprecated
     * @return
     * @throws JEVisException
     */
    String getConfigurationValue() throws JEVisException;

    /**
     * Set the additional configuration parameter. This funtion is not in use an
     * will be changed?!
     *
     * @deprecated
     * @return
     * @throws JEVisException
     */
    void setConfigurationValue(String value) throws JEVisException;

    /**
     * Set the expected unit for this type. All values of Attributes from type
     * type will be stored as this unit in the JEVisDataSource.
     *
     * @param unit
     * @throws JEVisException
     */
    void setUnit(Unit unit) throws JEVisException;

    /**
     * Return expected unit for this type. All values of Attributes from type
     * type will be stored as this unit in the JEVisDataSource.
     *
     * @return
     * @throws JEVisException
     */
    Unit getUnit() throws JEVisException;

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

    /**
     * Retuns the human description for the type. The funcion may be replaced
     * with an localized version.
     *
     * @deprecated
     * @return
     * @throws JEVisException
     */
    String getDescription() throws JEVisException;

    /**
     * Set the human description for the type.
     *
     * @param discription
     * @throws JEVisException
     */
    void setDescription(String discription) throws JEVisException;

    /**
     * Delete this type from the JEVisDataSource. This funcion does not need an
     * commit;
     *
     * @return
     * @throws JEVisException
     */
    boolean delete() throws JEVisException;
}
