/**
 * Copyright (C) 2013 - 2015 Envidatec GmbH <info@envidatec.com>
 *
 * This file is part of JECAPI.
 *
 * JECAPI is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation in version 3.
 *
 * JECAPI is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * JECAPI. If not, see <http://www.gnu.org/licenses/>.
 *
 * JECAPI is part of the OpenJEVis project, further project information are
 * published at <http://www.OpenJEVis.org/>.
 */
package org.jevis.api;

import org.joda.time.Period;

/**
 * The JEVisUnit class handels the converting and labeling of the JEVisSamples
 * values.
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisUnit {

    /**
     * SI prefixes and NONE if no prefix is set
     */
    public static enum Prefix {

        NONE, ZETTA, EXA, PETA, TERA, GIGA, MEGA, NANO, PICO, KILO, HECTO, DEKA, DECI, CENTI, MILLI, MICRO, NANOPICO, FEMTO, ATTO, ZEPTO, YOCTO
    }

    /**
     * Returns the label of this unit.
     *
     * @return
     */
    String getLabel();

    /**
     * Set the label for this unit.
     *
     * @param label
     */
    void setLabel(String label);

    /**
     * Convert an double value with this unit into the given unit.
     *
     * @param unit unit to convert to
     * @param number number to convert
     * @return
     */
    double converteTo(JEVisUnit unit, double number);

    /**
     * Add an offset to this unit.
     *
     * @param offset
     * @return
     */
    JEVisUnit plus(double offset);

    /**
     * Retuns an new Unit with the unit multiplying with the factor
     *
     * @param factor
     * @return
     */
    JEVisUnit times(double factor);

    /**
     * Returns an product with this unit combined with the specified.
     *
     * @param factor
     * @return
     */
    JEVisUnit times(JEVisUnit factor);

    /**
     * Returns an new Unit as an result of this unit deviedby the factor.
     *
     * @param factor
     * @return
     */
    JEVisUnit divide(double factor);

    /**
     * Returns an new Unit as an result of this unit devied with the fator unit.
     *
     * @param factor
     * @return
     */
    JEVisUnit divide(JEVisUnit factor);

    /**
     * Retuns true if this unit can be converted into the given unit.
     *
     * @param unit
     * @return
     */
    boolean isCompatible(JEVisUnit unit);

    /**
     * Set the Prefix for this Unit eg. Kilo, Mega, Giga...
     *
     * @param prefix
     */
    void setPrefix(Prefix prefix);

    /**
     * Retuns the current Prefix of this unit
     *
     * @return Prefix for unit, returns Prefix.NONE if no prefix is set
     */
    Prefix getPrefix();

    /**
     * Returns an JSON replresentaion of this Unit.
     *
     * @deprecated be careful using this function because it could be a
     * temporary solution until the JEVisUnit design is final
     * @return
     */
    String toJSON();

}
