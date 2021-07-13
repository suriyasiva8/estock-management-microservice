package com.estock.stockmanagement.dao.model;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

public abstract class AuditorBaseObject {

    @CreatedBy
    private String createdByUser;

    @Indexed
    @CreatedDate
    private Date creationDate = new Date();

    @LastModifiedDate
    private Date lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedUserId;

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedUserId() {
		return lastModifiedUserId;
	}

	public void setLastModifiedUserId(String lastModifiedUserId) {
		this.lastModifiedUserId = lastModifiedUserId;
	}
    
}
