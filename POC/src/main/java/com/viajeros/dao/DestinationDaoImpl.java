package com.viajeros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viajeros.entity.Destination;
import com.viajeros.exception.UpdateException;

@Repository
public class DestinationDaoImpl extends AbstractDaoImpl implements
		IDestinationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Destination> getDestinationList() {
		return getSession().createQuery(" from Destination ").list();
	}

	@Override
	public Destination saveDestination(Destination destination) {
		return (Destination)updateEntity(destination);	
	}

	@Override
	public Destination getDestinationById(Long id) {
		Query query = getSession().createQuery(" from Destination destination where destination.destinationId = :destinationId ");
		query.setLong("destinationId", id);
		return (Destination) query.uniqueResult();
	}

	@Override
	public void deleteDestination(Long id) throws UpdateException {
		Query query = getSession().createQuery(" delete from Destination destination where destination.destinationId = :destinationId ");
		query.setLong("destinationId", id);
		int result = query.executeUpdate();
		if(result==0)
			throw new UpdateException("Unable to delete. Entity Not found");
	}

}
