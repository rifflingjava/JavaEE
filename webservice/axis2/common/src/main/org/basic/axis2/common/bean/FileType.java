/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.common.bean.FileType.java is created on 2008-1-30
 */
package org.basic.axis2.common.bean;

/**
 * 
 */
public enum FileType {
    XML("XML"), PROPERTIES("PROPERTIES");

    private String name;

    private FileType(String name) {

        this.name = name;
    }

    /**
     * @return get method for the field name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {

        this.name = name;
    }
}
