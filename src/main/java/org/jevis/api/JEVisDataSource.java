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
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisDataSource {

    /**
     * Build an JEVisClass with the given name.
     *
     * @param name of the class. The has to be unique on the system.
     * @return JEVisClass
     * @throws JEVisException
     */
    JEVisClass buildClass(String name) throws JEVisException;

    /**
     * Build an other JEVisObject
     *
     * @param name of the JEVisObject
     * @param parent JEVisObject where the new will be createtd under.
     * @param jclass
     * @return
     * @throws JEVisException
     */
    //will be handelt by the JEVisOBject him self
//    JEVisObject buildObject(String name, JEVisObject parentObj, JEVisClass jclass) throws JEVisException;
    /**
     * Create an Symbolic link to an JEVisObject
     *
     * @param name Name of the new created link.
     * @param parent Parent JEVisObject under which the new Link will be created
     * @param linkedObject Target JEVisObject where the link links to
     * @return
     * @throws JEVisException
     */
    JEVisObject buildLink(String name, JEVisObject parent, JEVisObject linkedObject) throws JEVisException;

    /**
     * Get all Root Objects for the Current user.
     *
     * @return List of all JEVisObjects
     * @throws JEVisException
     */
    List<JEVisObject> getRootObjects() throws JEVisException;

    /**
     * Get all JEVisObject from a JEVisClass
     *
     * @param JEVisClass filter
     * @param addheirs if true all heirs of the JEVisClass will also be includet
     * @return
     * @throws JEVisException
     */
    List<JEVisObject> getObjects(JEVisClass jevisClass, boolean addheirs) throws JEVisException;

    /**
     * Get an JEVisObject by its unique ID
     *
     * @param id
     * @return
     * @throws JEVisException
     */
    JEVisObject getObject(Long id) throws JEVisException;

    /**
     * Get an JEVisClass by its Name
     *
     * @param name of the JEVisClass
     * @return
     * @throws JEVisException
     */
    JEVisClass getJEVisClass(String name) throws JEVisException;

    /**
     * Return all JEVisCalsses on the System
     *
     * @return
     * @throws JEVisException
     */
    List<JEVisClass> getJEVisClasses() throws JEVisException;

//    /**
//     * Get an JEVisGroup by its unique ID
//     *
//     * @param group
//     * @return
//     * @throws JEVisException
//     */
//    JEVisGroup getGroup(long group) throws JEVisException;
//
//    /**
//     * Get an JEVisUser by its unique Name
//     *
//     * @param name
//     * @return
//     * @throws JEVisException
//     */
//    JEVisUser getUser(String name) throws JEVisException;
//
//    /**
//     * Create an new JEVIsUser and an matching JEVisObject
//     *
//     * @param name of the new User. Has to be unique
//     * @param parent where the user JEVisObject is stored under
//     * @return
//     * @throws JEVisException
//     */
//    JEVisUser buildUser(String name, JEVisObject parent) throws JEVisException;
    /**
     * Return the current user logedin.
     *
     * @return
     */
    JEVisObject getCurrentUser() throws JEVisException;

    /**
     * Returns all relationships of a sertain type.
     *
     * @param type type of the relationship
     * @see JEVisConstants
     * @return
     * @throws JEVisException
     */
    List<JEVisRelationship> getReplationships(int type) throws JEVisException;

    /**
     * Connect to the DataSource as an JEVis user
     *
     * @param username
     * @param password
     * @return
     * @throws JEVisException
     */
    boolean connect(String username, String password) throws JEVisException;

    /**
     * Return the JEAPI implementaion infos like name & version number
     *
     * @return
     */
    JEVisInfo getInfo();
}
