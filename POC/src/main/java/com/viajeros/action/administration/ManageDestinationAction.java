package com.viajeros.action.administration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.viajeros.dao.IDestinationDao;
import com.viajeros.entity.Destination;
import com.viajeros.exception.UpdateException;
import com.viajeros.utils.Strings;

public class ManageDestinationAction extends AbstractAdminAction {
	
	private static final long serialVersionUID = -295199890861770511L;
	
	public ManageDestinationAction() {
		super();
	}

	@Autowired
	private IDestinationDao destinationDao;
	private List<Destination> destinationList;
	private Destination destination;
	
	public IDestinationDao getDestinationDao() {
		return destinationDao;
	}

	public void setDestinationDao(IDestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}
	

	@Transactional(readOnly=true)
	public String list(){
		destinationList =  destinationDao.getDestinationList();
		return SUCCESS;
	}
	
	@Transactional(readOnly=true)
	public String view(){
		if(!Strings.hasValue(getPrimaryId()))
			return INPUT;
		
		destination = destinationDao.getDestinationById(Long.valueOf(getPrimaryId()));
		if(null==destination)
			addActionError("Error: Destination not found!");
		
		return INPUT;
	}
	
	@Transactional(readOnly=false, rollbackFor=Throwable.class)
	public String save(){
		destinationDao.saveDestination(destination);
		destinationList = destinationDao.getDestinationList();
		addActionMessage("Destination saved successfully.");
		return SUCCESS;
	}
	
	@Transactional(readOnly=false, rollbackFor=Throwable.class)
	public String delete(){
		if(!Strings.hasValue(getPrimaryId()))
			return INPUT;
		try {
			destinationDao.deleteDestination(Long.valueOf(getPrimaryId()));
		} catch (NumberFormatException e) {
			addActionError(e.getMessage());
			return SUCCESS;
		} catch (UpdateException e) {
			addActionError(e.getMessage());
			return SUCCESS;
		} 
		destinationList =  destinationDao.getDestinationList();
		
		addActionMessage("Destination deleted successfully!");
		
		return SUCCESS;
	}
	
	
	@Override
	public void validate() {
		super.validate();
		if(destination==null){
			return;
		}
		
		if(null==destination.getName() || destination.getName().trim().isEmpty())
			addFieldError("destination.name", "Name is required");
				
	}

	public List<Destination> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(List<Destination> destinationList) {
		this.destinationList = destinationList;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@Override
	public String getEntityName() {
		return "Destination";
	}
	
	

}
