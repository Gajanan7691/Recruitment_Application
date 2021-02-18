package com.inn.recruitment.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ 
	
	 @NamedQuery(name = "findAll", query = "select e from Application e"),
	 @NamedQuery(name = "getAllByOfferId", query = "select e from Application e where e.offer.offerId=:offerId" ),
	 @NamedQuery(name = " getApplicationsCount", query = "select e from Application e"),
	
})

@Entity
@Table(name = "Application")
public class Application implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long applicatioId;

	@Column(nullable = false, unique = true)
	private String candidateEmail;

	@Column(nullable = false)
	private String resume;

	@Column(nullable = false)
	@Enumerated
	private ApplicationStatus applicationStatus;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_id", columnDefinition = "integer", referencedColumnName = "offerId")
	private Offer offer;

	public Long getApplicatioId() {
		return applicatioId;
	}

	public void setApplicatioId(Long applicatioId) {
		this.applicatioId = applicatioId;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
