/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jevis.api;

/**
 *
 * @author Florian Simon <florian.simon@envidatec.com>
 */
public interface JEVisOption {

    String getGroup();

    void setGroup(String group);

    String getValue();

    void setValue(String value);

    String getKey();

    void setKey(String key);

    boolean isRequired();

    void setRequired(boolean required);

    String getDescription();

    void setDescription(String description);

}
