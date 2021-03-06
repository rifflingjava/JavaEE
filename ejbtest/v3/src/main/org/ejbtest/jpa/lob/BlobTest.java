//$Id: BlobTest.java,v 1.1 2015/06/30 06:43:14 ygong Exp $
package org.ejbtest.jpa.lob;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

import org.ejbtest.jpa.TestCase;
import org.hibernate.Hibernate;

/**
 * @author Emmanuel Bernard
 */
public class BlobTest extends TestCase {

	public void testBlobSerialization() throws Exception {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Map image = new HashMap();
		image.put( "meta", "metadata" );
		image.put( "data", "imagedata" );
		ImageReader reader = new ImageReader();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream( baos );
		oos.writeObject( image );
		reader.setImage( (Blob) Hibernate.createBlob( baos.toByteArray() ) );
		em.persist( reader );
		em.getTransaction().commit();
		em.close(); //useless but y'a know
		em = factory.createEntityManager();
		em.getTransaction().begin();
		reader = em.find( ImageReader.class, reader.getId() );
		ObjectInputStream ois = new ObjectInputStream( reader.getImage().getBinaryStream() );
		image = (HashMap) ois.readObject();
		assertTrue( image.containsKey( "meta" ) );
		em.getTransaction().commit();
		em.close();
	}

	public Class[] getAnnotatedClasses() {
		return new Class[]{
				ImageReader.class
		};
	}
}
