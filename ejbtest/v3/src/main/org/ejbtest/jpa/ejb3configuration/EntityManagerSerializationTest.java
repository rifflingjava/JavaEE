//$Id: EntityManagerSerializationTest.java,v 1.1 2015/06/30 06:43:15 ygong Exp $
package org.ejbtest.jpa.ejb3configuration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.ejbtest.jpa.Cat;
import org.ejbtest.jpa.Distributor;
import org.ejbtest.jpa.Item;
import org.ejbtest.jpa.Wallet;
import org.hibernate.ejb.HibernateEntityManager;

/**
 * @author Emmanuel Bernard
 */
public class EntityManagerSerializationTest extends org.ejbtest.jpa.TestCase {

	public void testSerialization() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream( stream );
		out.writeObject( factory );
		out.close();
		byte[] serialized = stream.toByteArray();
		stream.close();
		ByteArrayInputStream byteIn = new ByteArrayInputStream( serialized );
		ObjectInputStream in = new ObjectInputStream( byteIn );
		EntityManagerFactory seriallizedFactory = (EntityManagerFactory) in.readObject();
		in.close();
		byteIn.close();
		EntityManager em = seriallizedFactory.createEntityManager();
		//em.getTransaction().begin();
		//em.setFlushMode( FlushModeType.NEVER );
		Cat cat = new Cat();
		cat.setAge( 3 );
		cat.setDateOfBirth( new Date() );
		cat.setLength( 22 );
		cat.setName( "Kitty" );
		em.persist( cat );
		Item item = new Item();
		item.setName( "Train Ticket" );
		item.setDescr( "Paris-London" );
		em.persist( item );
		//em.getTransaction().commit();
		//em.getTransaction().begin();
		item.setDescr( "Paris-Bruxelles" );
		//em.getTransaction().commit();

		//fake the in container work
		( (HibernateEntityManager) em ).getSession().disconnect();
		stream = new ByteArrayOutputStream();
		out = new ObjectOutputStream( stream );
		out.writeObject( em );
		out.close();
		serialized = stream.toByteArray();
		stream.close();
		byteIn = new ByteArrayInputStream( serialized );
		in = new ObjectInputStream( byteIn );
		em = (EntityManager) in.readObject();
		in.close();
		byteIn.close();
		//fake the in container work
		em.getTransaction().begin();
		item = em.find( Item.class, item.getName() );
		item.setDescr( item.getDescr() + "-Amsterdam" );
		cat = (Cat) em.createQuery( "select c from " + Cat.class.getName() + " c" ).getSingleResult();
		cat.setLength( 34 );
		em.flush();
		em.remove( item );
		em.remove( cat );
		em.flush();
		em.getTransaction().commit();

		em.close();
	}

	public Class[] getAnnotatedClasses() {
		return new Class[]{
				Item.class,
				Distributor.class,
				Wallet.class,
				Cat.class

		};
	}
}
