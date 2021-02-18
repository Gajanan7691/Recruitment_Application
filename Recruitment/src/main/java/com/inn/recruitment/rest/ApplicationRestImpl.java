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
import com.inn.recruitment.model.Application;
import com.inn.recruitment.service.IApplicationService;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/application")
@Produces("application/json")
@Consumes("application/json")
public class ApplicationRestImpl {

	private Logger logger = LoggerFactory.getLogger(ApplicationRestImpl.class);

	private final IApplicationService applicationService;

	public ApplicationRestImpl(IApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@POST
	@UnitOfWork
	@Path("createApplication")
	public Application createApplication(Application application) throws RestException {
		logger.info("@Rest => Going to create  application for {}", application);

		if (application == null) {
			throw new RestException("Application object for creation cannot be null");
		}
		return applicationService.createApplication(application);
	}

	@POST
	@UnitOfWork
	@Path("updateApplication")
	public Application updateApplication(Application application) throws RestException {

		logger.info("@Rest => Going to update  application for {}", application);

		if (application == null) {
			throw new RestException("Application objetct for updation cannot be null");
		}
		return applicationService.updateApplication(application);
	}

	@GET
	@UnitOfWork
	@Path("getApplicationById/{id}")
	public Application getApplicationById(@Valid @PathParam("id") Long id) throws RestException {
		logger.info("@Rest => Going to get application for id {}", id);
		if (id == null) {
			throw new RestException("Application id cannot be null");
		}

		return applicationService.getApplicationById(id);
	}

	@GET
	@UnitOfWork
	@Path("getAllOfferById/{offerId}")
	public List<Application> getAllOfferById(@PathParam("offerId") Long offerId) throws RestException {
		logger.info("Going to get All offer by offerId {}", offerId);
		if (offerId == null) {
			throw new RestException("OfferId id cannot be null");
		}
		return applicationService.getAllOfferById(offerId);
	}

	@GET
	@UnitOfWork
	@Path("getApplicationsCount")
	public Long getApplicationsCount() {
		logger.info("Going to get number of application");
		return applicationService.getApplicationsCount();
	}

}
