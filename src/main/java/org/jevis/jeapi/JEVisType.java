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

/**
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisType extends JEVisComponent, JEVisCommittable, Comparable<JEVisType> {

    String getName() throws JEVisException;

    void setName(String name) throws JEVisException;

    int getPrimitiveType() throws JEVisException;

    void setPrimitiveType(int type) throws JEVisException;

    String getGUIDisplayType() throws JEVisException;

    void setGUIDisplayType(String type) throws JEVisException;

    void setGUIPosition(int pos) throws JEVisException;

    int getGUIPosition() throws JEVisException;

    JEVisClass getJEVisClass() throws JEVisException;

    int getValidity() throws JEVisException;

    void setValidity(int validity) throws JEVisException;

    String getConfigurationValue() throws JEVisException;

    void setConfigurationValue(String value) throws JEVisException;

//    List<JEVisDefaultSample> getDefaultSamples();
//    void setDefaultSample(JEVisDefaultSample sample);
    JEVisUnit getDefaultUnit() throws JEVisException;

    void setDefaultUnit(JEVisUnit unit) throws JEVisException;

    String getDescription() throws JEVisException;

    void setDescription(String discription) throws JEVisException;

    boolean delete() throws JEVisException;
}
