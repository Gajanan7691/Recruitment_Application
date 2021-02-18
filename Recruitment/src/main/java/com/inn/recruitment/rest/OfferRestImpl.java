package com.inn.recruitment.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.recruitment.customexception.RestException;
import com.inn.recruitment.model.Offer;
import com.inn.recruitment.service.IOfferService;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/Offer")
@Produces("application/json")
@Consumes("application/json")
public class OfferRestImpl {

	private Logger logger = LoggerFactory.getLogger(OfferRestImpl.class);
	 
	private final IOfferService offerService;

	    public OfferRestImpl(IOfferService offerService) {
	        this.offerService = offerService;
	    }

	    @POST
	    @Path("create")
	    @UnitOfWork
	    public Offer create(@Valid Offer offer) throws RestException {
	    	logger.info("Going to create offer  for entity {}",offer);
			if (offer==null) {
				throw new RestException("Offer id cannot be null");
			}
	        return offerService.createOffer(offer);
	    }

	    @GET
	    @Path("getOfferById/{id}")
	    @UnitOfWork
	    public Offer getOfferById(@Valid @PathParam("id") Long id) throws RestException {
	    	logger.info("Going to get offer  by offerId {}",id);
			if (id==null) {
				throw new RestException("Offer id cannot be null");
			}
	        return offerService.getById(id);
	    }

	    @GET
	    @PathParam("getAllOffer")
	    @UnitOfWork
	    public List<Offer> getAllOffer() {
	    	logger.info("Going to get all offer");
	        return offerService.getAll();
	    }
	    
}
