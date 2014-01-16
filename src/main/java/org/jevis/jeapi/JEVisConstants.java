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
package org.jevis.jeapi;

/**
 *
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisConstants {

    public interface PrimitiveType {

        public static final int STRING = 0;
        public static final int DOUBLE = 1;
        public static final int LONG = 2;
        public static final int FILE = 3;
        public static final int BOOLEAN = 4;
        public static final int SELECTION = 5;
        public static final int MULTI_SELECTION = 6;
        public static final int PASSWORD_PBKDF2 = 7;
    }

    public interface DisplayType {

        public static final int LIST = 2;
    }

    public interface Direction {

        public static final int FORWARD = 0;
        public static final int BACKWARD = 1;
    }

    public interface Relationship {

        /**
         * From child to Parent
         */
        public static final int PARENT = 1;
        public static final int LINK = 2;
        /**
         * From Group to Root
         */
        public static final int ROOT = 3;
        /**
         * From object to Source
         */
        public static final int SOURCE = 4;
        /**
         * From object to source
         */
        public static final int SERVICE = 5;
        /**
         * from object to Input
         */
        public static final int INPUT = 6;
        public static final int DATA = 7;
        /**
         * From Object to Group
         */
        public static final int OWNER = 100;
        /**
         * From User to Group
         */
        public static final int MEMBER_READ = 101;
        /**
         * From User to Group
         */
        public static final int MEMBER_WRITE = 102;
        /**
         * From User to Group
         */
        public static final int MEMBER_EXCECUTE = 103;
        /**
         * From User to Group
         */
        public static final int MEMBER_CREATE = 104;
        /**
         * From User to Group
         */
        public static final int MEMBER_DELETE = 105;
    }

    public interface Class {

        public static final String USER = "User";
        public static final String GROUP = "Group";
    }

    public interface Attribute {

        public static final String USER_EMAIL = "Email";
        public static final String USER_SYS_ADMIN = "Sys Admin";
        public static final String USER_PASSWORD = "Password";
    }

    public interface Validity {

        public static final int LAST = 0;
        public static final int AT_DATE = 1;
    }
}
