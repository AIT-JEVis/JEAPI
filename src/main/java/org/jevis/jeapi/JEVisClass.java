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
    String getName() throws JEVisException;

    /**
     * Set The Name of this Class. Every class name is unique
     *
     * @param name
     */
    void setName(String name) throws JEVisException;

    /**
     * Get the Icon representing this JEVisClass.
     *
     * @return
     */
    ImageIcon getIcon() throws JEVisException;

    /**
     * Set the Icon representing this JEVisClass
     *
     * @param icon
     */
    void setIcon(ImageIcon icon) throws JEVisException;

    /**
     * Get the descrition for this JEVisClass. THe description is an help text
     * for the end user.
     *
     * @return
     */
    String getDescription() throws JEVisException;

    /**
     * Set the description for this JEVisClass.
     *
     * @param discription
     */
    void setDescription(String discription) throws JEVisException;

    /**
     * Get all type whiche are present for this JEVisClass
     *
     * @return
     */
    List<JEVisType> getTypes() throws JEVisException;

    /**
     * Get an spezific type by its unique name.
     *
     * @param typename
     * @return
     */
    JEVisType getType(String typename) throws JEVisException;

    /**
     * Build and add an new type under this JEVisClass. Every type has to be
     * unique under an JEVisClass.
     *
     * @param name
     * @return
     */
    JEVisType buildType(String name) throws JEVisException;

    /**
     * Get the inheritance class. This JEVisClass will inherit all types for all
     * inheritance. If the JEVIsClass does not need an inheritance it will
     * return NULL
     *
     * @return inheritance JEVisClass, null if it does not have an inheritance
     */
    JEVisClass getInheritance() throws JEVisException;

    /**
     * Get all heir classes.
     *
     * @return List of the heirs of this JEVisClass
     */
    List<JEVisClass> getHeirs() throws JEVisException;

    /**
     * Get the list of all parents this class is allowed under
     *
     * @return list of valid parents, emty list if non exist
     */
    List<JEVisClass> getValidParents() throws JEVisException;

    /**
     * Check if this JEVisClass is allowed under the given JEVisClass
     *
     * @param jevisClass
     * @return
     */
    boolean isAllowedUnder(JEVisClass jevisClass) throws JEVisException;

    /**
     * Check if thes JEVisClass has to be unique under one JEVisObject. This
     * funktion allwes to control the structure of the JEVis tree
     *
     * @return
     */
    boolean isUnique() throws JEVisException;

    /**
     * Set if the JEVisClass is unique under an other JEVisObject
     *
     * @param unique
     */
    void setUnique(boolean unique) throws JEVisException;

    /**
     * Delete this JEVisClass.
     *
     * @return
     * @throws JEVisException
     */
    boolean delete() throws JEVisException;

    /**
     * Return all relationships this class has
     *
     * @return all relationships
     * @throws JEVisException
     */
    List<JEVisClassRelationship> getRelationships() throws JEVisException;

    /**
     * Return all relationships from the given type
     *
     * @param type
     * @return all relationships from the given type
     * @throws JEVisException
     */
    List<JEVisClassRelationship> getRelationships(int type) throws JEVisException;

    /**
     * Return all relationships from the given type and direction
     *
     * @param type {@link org.jevis.jeapi.JEVisConstants.Relationship}
     * @param direction if Forward the he Class has to be the start, if Backward
     * the class has to be the end
     * @return all relationships from the given type and direction
     * @throws JEVisException
     */
    List<JEVisClassRelationship> getRelationships(int type, int direction) throws JEVisException;

    /**
     * Create and commit relationship an other JEVisClayss
     *
     * @param obj
     * @param type {@link org.jevis.jeapi.JEVisConstants.Relationship}
     * @param direction {@link org.jevis.jeapi.JEVisConstants.Direction}
     * @return the new relationship
     */
    JEVisClassRelationship buildRelationship(JEVisClass jclass, int type, int direction) throws JEVisException;

    /**
     * Delete an relationship for this class
     *
     * @param rel
     * @throws JEVisException
     */
    void deleteRelationship(JEVisClassRelationship rel) throws JEVisException;
}
