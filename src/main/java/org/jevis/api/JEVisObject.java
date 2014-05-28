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

/**
 * This interface represents an JEVis Object.
 *
 * Examples for an object are an customer, measurement device or an building. An
 * JEObject cannot store any samples. Measurable attributes of an Object like
 * the build year of an building are stored in the JEAttribute.
 *
 *
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisObject extends JEVisComponent, JEVisCommittable, Comparable<JEVisObject> {

    /**
     * Returns the name of the JEObject entity as String.
     *
     * Names are not unique in the JEVis system. For an unique use the ID.
     *
     * @return Name as String
     */
    String getName();

    /**
     * Set the name of the JEObject.
     *
     * @param name
     */
    void setName(String name) throws JEVisException;

    /**
     * Returns the unique identifier of this JEObject entity. The same ID cannot
     * appear twice on the same JEVis server. Its possible and very likey that
     * the same ID appear on different JEVis server.
     *
     * The ID cannot be set by the client an will be give from the server.
     *
     * @return identifier as Long
     */
    Long getID();

    /**
     * Returns the JEVis Object Type of this JEObject entity. Every JEObject is
     * from a certain Type which describes the Object attributes and its
     * handling.
     *
     * There can be unlimited JEObject entities from one JEObjectType.
     *
     * @return JEVisCalss
     */
    JEVisClass getJEVisClass() throws JEVisException;

    /**
     * Returns hierarchy parent of this JEObject entity.
     *
     * The JEObject are stored in tree like structure where every JEObject can
     * have unlimited JEObject children but just one JEObject parent.
     *
     * @return Parent as JEObject
     */
    List<JEVisObject> getParents() throws JEVisException;

    /**
     * Set the parent JEObject.
     *
     * @param object parent as JEObject
     */
//    void setParent(JEVisObject object) throws JEVisException;
    /**
     * move this JEVisObject to an other parent
     */
//    void moveTo(JEVisObject newParent) throws JEVisException;
    /**
     * Returns all hierarchy children as an list of JEObject. The List will be
     * empty if this JEobject has no children.
     *
     * @return List of all JEObject children
     */
    List<JEVisObject> getChildren() throws JEVisException;

    /**
     * Returns all children as an List of JEObject from the certain given
     * JEObjectType or all JEObjectTypes which inherit the type.
     *
     *
     * @param JEVisClass requested type as JEObjectType
     * @param boolean incute inherit classes
     * @return List of all accessible JEObject from the same Type or inherit
     * type.
     */
    List<JEVisObject> getChildren(JEVisClass type, boolean inherit) throws JEVisException;

    /**
     * Returns a List of all JEAttribute which the JEObjectType of this JEObject
     * entity has. If an JEAttribute is not set the default value will returned.
     *
     * @return List of JEAttribute which this JEObject have.
     */
    List<JEVisAttribute> getAttributes() throws JEVisException;

    /**
     * Returns an specific JEAttribute which is of the given JEAttributeType. If
     * the JEAttribute is not set the default values will returned.
     *
     * Will return an Exception if the JEAttributeType is not allowed unter the
     * JEObjectType
     *
     * @param type
     * @return JEAttribute from the given JEAttributeType
     */
    JEVisAttribute getAttribute(JEVisType type) throws JEVisException;

    /**
     * Returns an specific JEAttribute. If the JEAttribute is not set the
     * default values will returned.
     *
     * Will return an Exception if the JEAttributeType is not allowed unter the
     * JEObjectType
     *
     * @param type
     * @return JEAttribute from the given JEAttributeType
     */
    JEVisAttribute getAttribute(String type) throws JEVisException;

    /**
     * Delete this JEObject on the JEVis Server. This JEObject will be set to
     * null and will be removed from the child list of the parent.
     *
     * If this JEObject is an link it will only delete the link an not the
     * linked reference.
     *
     * All linked references will also be deleted.
     *
     * @return true if the delete was successful
     */
    boolean delete() throws JEVisException;

    /**
     * Build an new JEObject from the given JEObjectType and name under this
     * JEObject.
     *
     * Throws Exception if the JEObjectType is not allowed under this JEObject.
     *
     * @param name of the new created JEObject
     * @param type JEObjectType of the new created JEObject
     * @return new created JEObject
     */
    JEVisObject buildObject(String name, JEVisClass type) throws JEVisException;

    /**
     * Check if this JEVIsObject is an link to an other JEVIsObject. An link
     * will return the same attributes as the original linked
     *
     * @return
     */
    boolean isLink();

    //TODo: remove? is the a relationship type
    JEVisObject getLinkedObject() throws JEVisException;

    /**
     * Create an commit an new Relationship
     *
     * @param obj
     * @param type {@link org.jevis.jeapi.JEVisConstants.Relationship}
     * @param direction {@link org.jevis.jeapi.JEVisConstants.Direction}
     * @return
     */
    JEVisRelationship buildRelationship(JEVisObject obj, int type, int direction) throws JEVisException;

    /**
     * Delete an relationship for this object
     *
     * @param rel
     * @throws JEVisException
     */
    void deleteRelationship(JEVisRelationship rel) throws JEVisException;

    /**
     * Return all relationships this object has
     *
     * @return
     * @throws JEVisException
     */
    List<JEVisRelationship> getRelationships() throws JEVisException;

    /**
     * Return all relationships from the given type
     *
     * @param type
     * @return
     * @throws JEVisException
     */
    List<JEVisRelationship> getRelationships(int type) throws JEVisException;

    /**
     * Return all relationships from the given type
     *
     * @param type {@link org.jevis.jeapi.JEVisConstants.Relationship}
     * @param direction if Forward the he Class has to be the start, if Backward
     * the class has to be the end
     * @return
     * @throws JEVisException
     */
    List<JEVisRelationship> getRelationships(int type, int direction) throws JEVisException;

    /**
     * Return an list of all JEVisClass who ar allowd under this Object.
     *
     * @return
     * @throws JEVisException
     */
    List<JEVisClass> getAllowedChildrenClasses() throws JEVisException;
}
