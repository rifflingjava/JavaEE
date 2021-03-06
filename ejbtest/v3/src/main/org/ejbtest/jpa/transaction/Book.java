//$Id: Book.java,v 1.1 2015/06/30 06:43:20 ygong Exp $
package org.ejbtest.jpa.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Integer id;
	public String name;

	@Version
	public Integer version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
