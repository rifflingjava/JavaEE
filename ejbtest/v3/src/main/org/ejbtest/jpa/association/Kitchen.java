//$Id: Kitchen.java,v 1.1 2015/06/30 06:43:17 ygong Exp $
package org.ejbtest.jpa.association;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Kitchen {
	@Id @GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "kitchen")
	private Oven oven;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Oven getOven() {
		return oven;
	}

	public void setOven(Oven oven) {
		this.oven = oven;
	}
}
