/**
 * Copyright (C) 2013 - 2014 Envidatec GmbH <info@envidatec.com>
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

import java.util.List;
import javax.measure.unit.Unit;

/**
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisUnit {

    public static enum Type {

        PRODUCT, ALTERNATIV, LABEL, BASE
    }

    /**
     * Parse an Unit based on the "The Unified Code for Units of Measure"
     *
     *
     * @param unit
     * @see <a
     * href="http://unitsofmeasure.org/trac/">http://unitsofmeasure.org</a>
     * @return
     */
    JEVisUnit parseUnit(String unit);

    JEVisUnit parseUnit(Unit unit);

    JEVisUnit getSIUnit();

    /**
     * Get the "The Unified Code for Units of Measure" conform Symbol for this
     * unit
     *
     * @return
     */
    String getSymbol();

    String getLabel();

    Type getType();

    List<JEVisUnitRelationship> getRelationships();

    boolean equals(JEVisUnit unit);

    boolean isCompatible(JEVisUnit unit);
}
