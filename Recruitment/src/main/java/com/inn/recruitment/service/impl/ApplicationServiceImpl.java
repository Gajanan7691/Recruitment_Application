package com.inn.recruitment.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.recruitment.dao.IApplicationDao;
import com.inn.recruitment.model.Application;
import com.inn.recruitment.service.IApplicationService;


public class ApplicationServiceImpl implements IApplicationService{

	private Logger logger=LoggerFactory.getLogger(ApplicationServiceImpl.class);
	
	private IApplicationDao applicationDao;
	
	
	public ApplicationServiceImpl(IApplicationDao applicationDao) {
		this.applicationDao=applicationDao;
	}

	@Override
	public Application createApplication(Application application) {
		
		return applicationDao.createApplication(application);
	}

	@Override
	public Application updateApplication(Application application) {
		
		return applicationDao.updateApplication(application);
	}

	@Override
	public Application getApplicationById(Long id) {
		
		return applicationDao.getApplicationById(id);
	}

	@Override
	public List<Application> getAllOfferById(Long offerId) {
		// TODO Auto-generated method stub
		return applicationDao.getAllOfferById(offerId);
	}

	@Override
	public Long getApplicationsCount() {
		// TODO Auto-generated method stub
		return applicationDao.getApplicationsCount();
	}

}
