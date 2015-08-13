/**
 * Copyright (C) 2013 - 2015 Envidatec GmbH <info@envidatec.com>
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
 * The JEVisDataSource handles the communication between the Server and client.
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisDataSource {

    /**
     * Initialize the datasource with the given configuration, will overwrite
     * the existing configuration
     *
     * @param config
     * @throws IllegalArgumentException
     */
    void init(List<JEVisOption> config) throws IllegalArgumentException;

    /**
     * Returns the configuration in use.
     *
     * @return
     */
    List<JEVisOption> getConfiguration();

    /**
     * Replace the current configuration
     *
     * @param config
     */
    void setConfiguration(List<JEVisOption> config);

    /**
     * Build a JEVisClass with the given name.
     *
     * @param name of the class. The class has to be unique on the system.
     * @return JEVisClass
     * @throws JEVisException
     */
    JEVisClass buildClass(String name) throws JEVisException;

    /**
     * Create a symbolic link to a JEVisObject
     *
     * @param name Name of the new created link.
     * @param parent Parent JEVisObject under which the new link will be created
     * @param linkedObject Target JEVisObject where the link links to
     * @return
     * @throws JEVisException
     */
    JEVisObject buildLink(String name, JEVisObject parent, JEVisObject linkedObject) throws JEVisException;

    /**
     * Get all root objects for the current user.
     *
     * @return List of all root-JEVisObjects
     * @throws JEVisException
     */
    List<JEVisObject> getRootObjects() throws JEVisException;

    /**
     * Get all JEVisObjects from a JEVisClass
     *
     * @param jevisClass
     * @param addheirs if true all heirs of the JEVisClass will also be included
     * @return
     * @throws JEVisException
     */
    List<JEVisObject> getObjects(JEVisClass jevisClass, boolean addheirs) throws JEVisException;

    /**
     * Get a JEVisObject by its unique ID
     *
     * @param id
     * @return
     * @throws JEVisException
     */
    JEVisObject getObject(Long id) throws JEVisException;

    /**
     * Get a JEVisClass by its name
     *
     * @param name Name of the JEVisClass
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

    /**
     * Return the user currently logged in.
     *
     * @return
     * @throws JEVisException
     */
    JEVisObject getCurrentUser() throws JEVisException;

    /**
     * Returns all relationships of a certain type.
     *
     * @param type type of the relationship
     * @see JEVisConstants
     * @return
     * @throws JEVisException
     */
    List<JEVisRelationship> getReplationships(int type) throws JEVisException;

    /**
     * Connect to the DataSource as a JEVis user
     *
     * @param username
     * @param password
     * @return
     * @throws JEVisException
     */
    boolean connect(String username, String password) throws JEVisException;

    /**
     * Close the DataSource connection
     *
     * @return
     * @throws JEVisException
     */
    boolean disconnect() throws JEVisException;

    /**
     * Try to reconnect with the same user if the connection was lost
     *
     * @return
     * @throws JEVisException
     */
    boolean reconnect() throws JEVisException;

    /**
     * Return the JEAPI implementation informations like name & version number
     *
     * @return
     */
    JEVisInfo getInfo();

    /**
     * Check if the connection is still alive returns true if the connection is
     * still alive
     *
     * @return
     * @throws JEVisException
     */
    boolean isConnectionAlive() throws JEVisException;

    /**
     * Returns a list of all additional JEVisUnits installed on this system. The
     * static default list of the most common units can be found in the project
     * JECommons.
     *
     * @return list of all additional JEVisUnits
     */
    List<JEVisUnit> getUnits();
}
