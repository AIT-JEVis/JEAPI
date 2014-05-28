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

/**
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisUnit {

    // ISO Standard?
    boolean isSIUnit();

    JEVisUnit getSIUnit();

    String getSymbol();

    boolean equals(JEVisUnit unit);

    boolean isCompatible(JEVisUnit unit);
}
