package org.ejbtest.account.persistence.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "Camion")
@Table(name = "EJB_IHT_TablePerClass_Camion")
public class Camion extends Car {

    private String container;// 集装箱

    @Column(name = "camion_container", nullable = true, length = 30)
    public String getContainer() {

        return container;
    }

    public void setContainer(String container) {

        this.container = container;
    }

}
