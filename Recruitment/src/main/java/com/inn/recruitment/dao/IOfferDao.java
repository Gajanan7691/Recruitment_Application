package com.inn.recruitment.dao;

import java.util.List;

import com.inn.recruitment.model.Offer;

public interface IOfferDao {

	Offer createOffer(Offer offer);

	List<Offer> getAllOffer();

	Offer getOfferById(Long id);

}
