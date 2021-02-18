package com.inn.recruitment.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.recruitment.dao.IOfferDao;
import com.inn.recruitment.model.Offer;
import com.inn.recruitment.service.IOfferService;

public class OfferServiceImpl implements IOfferService{
	
	private Logger logger=LoggerFactory.getLogger(OfferServiceImpl.class);

	public IOfferDao offerDao;
	
	
	public OfferServiceImpl(IOfferDao offerDao) {
		this.offerDao = offerDao;
	}

	@Override
	public Offer createOffer(Offer offer) {
		// TODO Auto-generated method stub
		return offerDao.createOffer(offer);
	}

	@Override
	public Offer getById(long id) {
		// TODO Auto-generated method stub
		 return offerDao.getOfferById(id);
	}

	@Override
	public List<Offer> getAll() {
		// TODO Auto-generated method stub
		return offerDao.getAllOffer();
	}

}
