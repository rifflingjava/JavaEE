/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.hibernate3.core.hello.persistence.Worker.java is created on 2008-4-7
 */
package org.third.orm.hibernate3.core.hello.persistence;


/**
 * 
 */
public class Worker extends Person {

    private String position;

    /**
     * @return get method for the field position
     */
    public String getPosition() {

        return this.position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(String position) {

        this.position = position;
    }
}
