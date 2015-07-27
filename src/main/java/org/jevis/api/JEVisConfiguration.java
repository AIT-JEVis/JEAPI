/**
 * Copyright (C) 2015 Envidatec GmbH <info@envidatec.com>
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
 * Interface to hold the configuration of an JEVisDataSource
 *
 * @author Florian Simon
 */
public interface JEVisConfiguration {

    /**
     * Return true if the Configuraion hold this option.
     *
     * @param group
     * @param key
     * @return
     */
    boolean hasOption(String group, String key);

    /**
     * Return true if the Configuraion hold this option.
     *
     * @param option
     * @return
     */
    boolean hasOption(JEVisOption option);

    /**
     * Returns the option with the given option-group and key.
     *
     * @param group
     * @param key
     * @return the option with the given option-group and key, returns an emty
     * option if it not exists.
     */
    JEVisOption getOption(String group, String key);

    /**
     * returns the Option thw the same group and key as the given option if it
     * exists.
     *
     * @param option Option to compare group and key to
     * @return
     */
    JEVisOption getOption(JEVisOption option);

    /**
     * retrun the complite list of all options.
     *
     * @return
     */
    List<JEVisOption> getOptions();

    /**
     * Add an new option.
     *
     * @param option option to add
     * @param overwrite if true the option will overwrite an existin option with
     * the same key/group
     */
    void addOption(JEVisOption option, boolean overwrite);

    /**
     * Combines this configuration with an other configuration. Existin option
     * in this configuration will not be overwriten.
     *
     * @param other
     */
    void completeWith(JEVisConfiguration other);

}
