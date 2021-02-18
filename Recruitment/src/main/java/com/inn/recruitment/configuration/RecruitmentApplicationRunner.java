package com.inn.recruitment.configuration;

import com.inn.recruitment.dao.IApplicationDao;
import com.inn.recruitment.dao.IOfferDao;
import com.inn.recruitment.dao.impl.ApplicationDaoImpl;
import com.inn.recruitment.dao.impl.OfferDaoImpl;
import com.inn.recruitment.model.Offer;
import com.inn.recruitment.rest.ApplicationRestImpl;
import com.inn.recruitment.rest.OfferRestImpl;
import com.inn.recruitment.service.IApplicationService;
import com.inn.recruitment.service.IOfferService;
import com.inn.recruitment.service.impl.ApplicationServiceImpl;
import com.inn.recruitment.service.impl.OfferServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RecruitmentApplicationRunner extends Application<AppConfiguration> {

	private final HibernateBundle<AppConfiguration> hibernateBundle = new HibernateBundle<AppConfiguration>(
			com.inn.recruitment.model.Application.class, Offer.class) {

		@Override
		public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}

	};

	@Override
	public void initialize(final Bootstrap<AppConfiguration> bootstrap) {
		bootstrap.addBundle(hibernateBundle);
	}

	@Override
	public void run(final AppConfiguration configuration, final Environment environment) {
		IApplicationDao applicationDao = new ApplicationDaoImpl(hibernateBundle.getSessionFactory());

		IOfferDao offerDao = new OfferDaoImpl(hibernateBundle.getSessionFactory());

		IApplicationService applicationService = new ApplicationServiceImpl(applicationDao);
		IOfferService offerService = new OfferServiceImpl(offerDao);

		environment.jersey().register(new ApplicationRestImpl(applicationService));
		environment.jersey().register(new OfferRestImpl(offerService));
	}

	public static void main(String[] args) throws Exception {
		new RecruitmentApplicationRunner().run(args);
	}

}