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
public interface JEVisRelationship {

    /**
     * Retruns the start node of the relationship.
     *
     * @return the start node of the relationship
     */
    JEVisObject getStartObject() throws JEVisException;

    /**
     * Returns the end node of the relationship .
     *
     * @return the end node of the relationship
     */
    JEVisObject getEndObject() throws JEVisException;

    /**
     * Returns both Objects of this relationship
     *
     * @return
     */
    JEVisObject[] getObjects() throws JEVisException;

    /**
     * Returns the other Object of this relationship.
     *
     * @param object the other JEVisObject
     * @return
     */
    JEVisObject getOtherObject(JEVisObject object) throws JEVisException;

    /**
     * Returns the type of this replationship
     *
     * @see org.jevis.jeapi.JEVisConstants.Relationship
     * @return type of this replationship
     */
    int getType() throws JEVisException;

    /**
     * Checks if this relationship is from the given type
     *
     * @see org.jevis.jeapi.JEVisConstants.Relationship
     * @param type
     * @return
     */
    boolean isType(int type) throws JEVisException;

    /**
     * Delete this relationship
     */
    void delete();
}
