//$Id: ProgrammaticConfTest.java,v 1.1 2015/06/30 06:43:15 ygong Exp $
package org.ejbtest.jpa.ejb3configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.ejbtest.jpa.Cat;
import org.hibernate.cfg.Environment;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.util.ConfigHelper;

/**
 * @author Emmanuel Bernard
 */
public class ProgrammaticConfTest extends junit.framework.TestCase {

	public void testProgrammaticAPI() throws Exception {
		Ejb3Configuration conf = new Ejb3Configuration();
		conf.addAnnotatedClass( Cat.class );
		EntityManagerFactory emf = conf.buildEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Cat cat = new Cat();
		cat.setAge( 23 );
		cat.setDateOfBirth( new Date() );
		cat.setLength( 32 );
		cat.setName( "Tomy" );
		em.getTransaction().begin();
		em.persist( cat );
		em.flush();
		assertNotNull( em.find(Cat.class, cat.getId() ) );
		em.getTransaction().rollback();
		emf.close();
	}

	protected Properties getProperties() throws IOException {
		Properties properties = new Properties( );
		InputStream stream = ConfigHelper.getResourceAsStream("/hibernate.properties");
		try {
			properties.load(stream);
		}

		finally {
			try{
				stream.close();
			}
			catch (IOException ioe){
			}
		}
		properties.setProperty( Environment.HBM2DDL_AUTO, "create-drop" );
		return properties;
	}


}
