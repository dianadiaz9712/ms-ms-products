package com.prototype.product.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

	@Column(name = "usercreate", nullable = false, updatable = false)
	@CreatedBy()
	protected String createdBy;

	@CreatedDate
	@Column(name = "datecreate", nullable = false, updatable = false)
	protected Date createdDate;

	@Column(name = "userupdate")
	@LastModifiedBy
	protected String lastModifiedBy;

	@Column(name = "dateupdate")
	@LastModifiedDate
	protected Date lastModifiedDate;
}
