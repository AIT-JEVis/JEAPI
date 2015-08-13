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
 * Container to store some comment configuration values. this will be used for
 * the configuration of the JEVisDatasource, localization, MetaData and so on
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisOption {

    /**
     * Get the parent option. JEVisOptions can be organized in an tree structure
     * where every option can have one parent and unlimited children
     *
     * @return parent option or null
     */
    JEVisOption getParent();

    /**
     * Get an list with all children options
     *
     * @return
     */
    List<JEVisOption> getChildren();

    /**
     * returns an single option by name
     *
     * @param optionName
     * @return
     */
    JEVisOption getChildren(String optionName);

    /**
     * returns if this option has an child with the given name,
     *
     * @param optionName
     * @return true if the option existis, false if not
     */
    boolean hasChildren(String optionName);

    /**
     * Add an new child option to this option.
     *
     * @param option new child option
     * @param overwrite if true overwrite the allready existing option.
     */
    void addChildren(JEVisOption option, boolean overwrite);

    /**
     * returns the vlaue for this option
     *
     * @return
     */
    String getValue();

    /**
     * Sset the vlaue for this option
     *
     * @param value
     */
    void setValue(String value);

    /**
     * return the key/name of this option
     *
     * @return
     */
    String getKey();

    /**
     * Set the key of this option
     *
     * @TODO: maybe this funktion is not save because the parent cannot check if
     * the open is allready in use. better use the constructor and add to check
     * this
     * @param key
     */
    void setKey(String key);

    /**
     * return if this option necessary
     *
     * @return
     */
    boolean isRequired();

    /**
     * Set if this option is necessary
     *
     * @param required
     */
    void setRequired(boolean required);

    /**
     * returns an human readable descripion
     *
     * @return
     */
    String getDescription();

    /**
     * Set the human readable descripion
     *
     * @param description
     */
    void setDescription(String description);

}
