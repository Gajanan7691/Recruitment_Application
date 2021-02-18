package com.inn.recruitment.dao;

import java.util.List;

import com.inn.recruitment.model.Application;

public interface IApplicationDao {


	Application createApplication(Application application);

	Application updateApplication(Application application);

	List<Application> getAllOfferById(Long offerId);

	Long getApplicationsCount();

	Application getApplicationById(Long id);



}
