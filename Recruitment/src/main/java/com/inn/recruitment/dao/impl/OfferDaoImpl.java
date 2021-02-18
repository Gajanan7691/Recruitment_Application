package com.inn.recruitment.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.recruitment.dao.IOfferDao;
import com.inn.recruitment.model.Offer;
import com.inn.recruitment.rest.ApplicationRestImpl;

import io.dropwizard.hibernate.AbstractDAO;

public class OfferDaoImpl extends AbstractDAO<Offer> implements IOfferDao {

	private Logger logger = LoggerFactory.getLogger(OfferDaoImpl.class);
	public OfferDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Offer createOffer(Offer offer) {
		try {
			return persist(offer);
		}catch(Exception e) {
			logger.error("Error in creating offer due to {}",e.getStackTrace());
		}
		return offer;
	}

	@Override
	public Offer getOfferById(Long id) {
		try {
			return  get(id);
		}catch(Exception e) {
			logger.error("Error im getting offer due to {}",e.getStackTrace());
			return null;
		}
		
		
	}

	@Override
	public List<Offer> getAllOffer() {
		
		try {
			return list(namedQuery("getAllOffer"));
		}catch(Exception e) {
			logger.error("Error im getting All offer due to {}",e.getStackTrace());
			return null;
		}
		
		
	}

}
