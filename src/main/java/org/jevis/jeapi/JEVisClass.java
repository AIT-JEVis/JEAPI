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
package org.jevis.jeapi;

import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisClass extends JEVisComponent, JEVisCommittable {

    /**
     * Set the name of this JEVisClass. The Class has to be unique.
     *
     *
     * @return
     */
    String getName();

    /**
     * Set The Name of this Class. Every class name is unique
     *
     * @param name
     */
    void setName(String name);

    /**
     * Get the Icon representing this JEVisClass.
     *
     * @return
     */
    ImageIcon getIcon();

    /**
     * Set the Icon representing this JEVisClass
     *
     * @param icon
     */
    void setIcon(ImageIcon icon);

    /**
     * Get the descrition for this JEVisClass. THe description is an help text
     * for the end user.
     *
     * @return
     */
    String getDescription();

    /**
     * Set the description for this JEVisClass.
     *
     * @param discription
     */
    void setDescription(String discription);

    /**
     * Get all type whiche are present for this JEVisClass
     *
     * @return
     */
    List<JEVisType> getTypes();

    /**
     * Get an spezific type by its unique name.
     *
     * @param typename
     * @return
     */
    JEVisType getType(String typename);

    /**
     * Build and add an new type under this JEVisClass. Every type has to be
     * unique under an JEVisClass.
     *
     * @param name
     * @return
     */
    JEVisType buildType(String name);

    /**
     * Get the inheritance class. This JEVisClass will inherit all types for all
     * inheritance. If the JEVIsClass does not need an inheritance it will
     * return NULL
     *
     * @return inheritance JEVisClass, null if it does not have an inheritance
     */
    JEVisClass getInheritance();

    /**
     * Get all heir classes.
     *
     * @return List of the heirs of this JEVisClass
     */
    List<JEVisClass> getHeirs() throws JEVisException;

    /**
     * Set the inheritance class, if it does not have any set it to null
     *
     * @param jevisClass
     */
    void setInheritance(JEVisClass jevisClass);

    /**
     * Add an new valid parent. An valid parent will allow that an JEVisObject
     * form this class can be createt under an other JEVIsOBject from the given
     * type.
     *
     * @param jevisClass
     */
    void addValidParent(JEVisClass jevisClass);

    /**
     * Get the list of all parents this class is allowed under
     *
     * @return list of valid parents, emty list if non exist
     */
    List<JEVisClass> getValidParents();

    /**
     * Remove an valid parent for the list.
     *
     * @param jevisClass
     */
    void removeValidParent(JEVisClass jevisClass);

    /**
     * Check if this JEVisClass is allowed under the given JEVisClass
     *
     * @param jevisClass
     * @return
     */
    boolean isAllowedUnder(JEVisClass jevisClass);

    /**
     * Check if thes JEVisClass has to be unique under one JEVisObject. This
     * funktion allwes to control the structure of the JEVis tree
     *
     * @return
     */
    boolean isUnique();

    /**
     * Set if the JEVisClass is unique under an other JEVisObject
     *
     * @param unique
     */
    void setUnique(boolean unique);

    /**
     * Delete this JEVisClass.
     *
     * @return
     * @throws JEVisException
     */
    boolean delete() throws JEVisException;
}
