package com.inn.recruitment.service;

import java.util.List;

import com.inn.recruitment.model.Application;

public interface IApplicationService {

	Application createApplication(Application application);

	Application updateApplication(Application application);

	Application getApplicationById(Long id);

	List<Application> getAllOfferById(Long offerId);

	Long getApplicationsCount();

}
