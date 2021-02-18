package com.inn.recruitment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.recruitment.dao.IApplicationDao;
import com.inn.recruitment.model.Application;

import io.dropwizard.hibernate.AbstractDAO;

public class ApplicationDaoImpl extends AbstractDAO<Application> implements IApplicationDao {

	private Logger logger = LoggerFactory.getLogger(ApplicationDaoImpl.class);

	public ApplicationDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Application> findAll() {
		return list(namedQuery("findAll"));
	}

	@Override
	public Application getApplicationById(Long id) {
		try {
			return get(id);
		} catch (Exception e) {
			logger.error("Error in getting Application for id {} due to {}", id, e.getStackTrace());
			return null;
		}
	}

	@Override
	public Application createApplication(Application application) {
		try {
			return persist(application);
		} catch (Exception e) {
			logger.error("Error in creating Application due to {}", e.getStackTrace());
			return application;
		}

	}

	@Override
	public Application updateApplication(Application application) {
		try {
			return persist(application);
		} catch (Exception e) {
			logger.error("Error in updating Application due to {}", e.getStackTrace());
			return application;
		}
	}

	@Override
	public List<Application> getAllOfferById(Long offerId) {
		try {
			return list(namedQuery("getAllByOfferId").setParameter("offerId", offerId));
		} catch (Exception e) {
			logger.error("Error in getting All offer for offerId {} due to {}", e.getStackTrace());
			return new ArrayList<Application>();
		}
	}

	@Override
	public Long getApplicationsCount() {
		try {
			return Long.valueOf(list(namedQuery("getApplicationsCount")).size());
		} catch (Exception e) {
			logger.error("Error in getting all application couunt due to {}", e.getStackTrace());
			return null;
		}
	}
}
