package com.inn.recruitment.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({ 
	
	 @NamedQuery(name = "getAllOffer", query = "select o from Offer o"),
	 
	 
})
@Entity
@Table(name="Offer")
public class Offer implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offerId;
  
    @Column(nullable = false, unique = true)
    private String jobTitle;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Column(nullable = false)
    private Integer numberOfApplications;

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getNumberOfApplications() {
		return numberOfApplications;
	}

	public void setNumberOfApplications(Integer numberOfApplications) {
		this.numberOfApplications = numberOfApplications;
	}
    
    
}
