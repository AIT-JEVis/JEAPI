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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Container to store some common configuration values. This will be used for
 * the configuration of JEVisDatasource, localization, MetaData and so on
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
@XmlRootElement(name = "Option")
public interface JEVisOption {

    /**
     * Get the parent option. JEVisOptions can be organized in a tree structure
     * where every option can have one parent and unlimited children
     *
     * @return parent option or null
     */
    @XmlElement(name = "parent")
    JEVisOption getParent();

    /**
     * Get a list with all children options
     *
     * @return
     */
    @XmlElement(name = "options")
    List<JEVisOption> getChildren();

    /**
     * returns a single option by name
     *
     * @param optionName
     * @return
     */
    JEVisOption getChildren(String optionName);

    /**
     * returns if this option has a child with the given name,
     *
     * @param optionName
     * @return true if the option exists, false if not
     */
    boolean hasChildren(String optionName);

    /**
     * Add a new child option to this option.
     *
     * @param option new child option
     * @param overwrite if true overwrite the already existing option.
     */
    void addChildren(JEVisOption option, boolean overwrite);

    /**
     * returns the value for this option
     *
     * @return
     */
    @XmlElement(name = "value")
    String getValue();

    /**
     * Set the value for this option
     *
     * @param value
     */
    void setValue(String value);

    /**
     * return the key/name of this option
     *
     * @return
     */
    @XmlElement(name = "key")
    String getKey();

    /**
     * Set the key of this option
     *
     * @TODO: maybe this function is not save because the parent cannot check if
     * the open is already in use. Better use the constructor and add to check
     * this
     * @param key
     */
    void setKey(String key);

    /**
     * Return true if this option required
     *
     * @return
     */
    @XmlElement(name = "required")
    boolean isRequired();

    /**
     * Set if this option is necessary
     *
     * @param required
     */
    void setRequired(boolean required);

    /**
     * Returns an human readable descripion
     *
     * @return
     */
    @XmlElement(name = "description")
    String getDescription();

    /**
     * Set the human readable description
     *
     * @param description
     */
    void setDescription(String description);

}
