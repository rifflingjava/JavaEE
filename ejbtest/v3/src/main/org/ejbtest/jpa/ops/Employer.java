//$Id: Employer.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.ops;

import java.io.Serializable;
import java.util.Collection;


/**
 * Employer in a employer-Employee relationship
 *
 * @author Emmanuel Bernard
 */

public class Employer implements Serializable {
	private Integer id;
	private Collection employees;


	public Collection getEmployees() {
		return employees;
	}


	public Integer getId() {
		return id;
	}

	public void setEmployees(Collection set) {
		employees = set;
	}

	public void setId(Integer integer) {
		id = integer;
	}
}
