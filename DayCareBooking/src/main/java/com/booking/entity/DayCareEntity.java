package com.booking.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
	@Table(name="Vendor_Daycare")
public class DayCareEntity {
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long daycareId;

		    private double serviceCost;
		    private String serviceType;
		    private String petType;
		    private String location;
		    private String description;
		    @Lob
		    @Column(columnDefinition = "MEDIUMBLOB")
		    private String image;
		
			
			@ManyToOne
			@JsonIgnore
			@JoinColumn(name = "vendorId")
			private VendorEntity vendor;

			


			public Long getDaycareId() {
				return daycareId;
			}


			public void setDaycareId(Long daycareId) {
				this.daycareId = daycareId;
			}


			public double getServiceCost() {
				return serviceCost;
			}


			public void setServiceCost(double serviceCost) {
				this.serviceCost = serviceCost;
			}


			public String getServiceType() {
				return serviceType;
			}


			public void setServiceType(String serviceType) {
				this.serviceType = serviceType;
			}


			public String getLocation() {
				return location;
			}


			public void setLocation(String location) {
				this.location = location;
			}


			public String getDescription() {
				return description;
			}


			public void setDescription(String description) {
				this.description = description;
			}


			public String getImage() {
				return image;
			}


			public void setImage(String image) {
				this.image = image;
			}


			public VendorEntity getVendor() {
				return vendor;
			}


			public void setVendor(VendorEntity vendor) {
				this.vendor = vendor;
			}


			public String getPetType() {
				return petType;
			}


			public void setPetType(String petType) {
				this.petType = petType;
			}



			public DayCareEntity(Long daycareId, double serviceCost, String serviceType, String petType,
					String location, String description, String image, VendorEntity vendor) {
				super();
				this.daycareId = daycareId;
				this.serviceCost = serviceCost;
				this.serviceType = serviceType;
				this.petType = petType;
				this.location = location;
				this.description = description;
				this.image = image;
				this.vendor = vendor;
			}


			public DayCareEntity() {
				super();
				// TODO Auto-generated constructor stub
			}
	

}
