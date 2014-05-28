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
 * JECAPI. If not, see <http://www.gnu.org/licenses/>.
 *
 * JEAPI is part of the OpenJEVis project, further project information are
 * published at <http://www.OpenJEVis.org/>.
 */
package org.jevis.api;

import java.util.List;

/**
 * This interface models the an relationship between two JEVisClasses
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisClassRelationship {

    /**
     * Returns the start JEVisClass of this relationship
     *
     * @return start JEVisCalss
     * @throws JEVisException
     */
    JEVisClass getStart() throws JEVisException;

    /**
     * Returns the end JEVisClass of this relationship
     *
     * @return end JEVisClass
     * @throws JEVisException
     */
    JEVisClass getEnd() throws JEVisException;

    /**
     * Returns the type of the relationship.
     *
     * @return the type
     * @throws JEVisException
     */
    int getType() throws JEVisException;

    /**
     * Returns both JEVisClass
     *
     * @return both JEVisClass
     * @throws JEVisException
     */
    JEVisClass[] getJEVisClasses() throws JEVisException;

    /**
     * Returns the other JEVIClass
     *
     * @return the other JEVIClass
     * @throws JEVisException
     */
    JEVisClass getOtherClass(JEVisClass jclass) throws JEVisException;

    /**
     * Check the type
     *
     * @return <CODE>true</CODE> if its the same type
     * @throws JEVisException
     */
    boolean isType(int type) throws JEVisException;

    /**
     * return if this Relationship is inherited from an other class
     *
     * @return CODE>true</CODE> if is inherited
     * @throws JEVisException
     */
    boolean isInHerited() throws JEVisException;
}
