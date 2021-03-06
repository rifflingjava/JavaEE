//$Id: LockTest.java,v 1.1 2015/06/30 06:43:14 ygong Exp $
package org.ejbtest.jpa.lock;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.ejbtest.jpa.TestCase;

/**
 * @author Emmanuel Bernard
 */
public class LockTest extends TestCase {

	public void testLockRead() throws Exception {
		Lock lock = new Lock();
		lock.setName( "name" );
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist( lock );
		em.getTransaction().commit();

		em.getTransaction().begin();
		lock = em.getReference( Lock.class, lock.getId() );
		em.lock( lock, LockModeType.READ );
		lock.setName( "surname" );
		em.getTransaction().commit();

		em.getTransaction().begin();
		lock = em.find( Lock.class, lock.getId() );
		assertEquals( "surname", lock.getName() );
		em.remove( lock );
		em.getTransaction().commit();
	}

	public void testLockWrite() throws Exception {
		Lock lock = new Lock();
		lock.setName( "second" );
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist( lock );
		em.getTransaction().commit();

		em.getTransaction().begin();
		lock = em.getReference( Lock.class, lock.getId() );
		Integer version = lock.getVersion();
		em.lock( lock, LockModeType.WRITE );
		em.getTransaction().commit();

		em.getTransaction().begin();
		lock = em.getReference( Lock.class, lock.getId() );
		try {
			assertEquals( "should increase the version number EJB-106", 1, lock.getVersion() - version );
		}
		finally {
			em.remove( lock );
			em.getTransaction().commit();
		}
	}

	public Class[] getAnnotatedClasses() {
		return new Class[]{
				Lock.class
		};
	}
}
