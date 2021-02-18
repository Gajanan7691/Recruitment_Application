package com.inn.recruitment.service;

import java.util.List;

import com.inn.recruitment.model.Offer;

public interface IOfferService {

	Offer createOffer(Offer offer);

	Offer getById(long id);

	List<Offer> getAll();

}
