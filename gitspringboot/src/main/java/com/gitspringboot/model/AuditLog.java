package com.gitspringboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AUDIT_LOG")
public class AuditLog implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "AUDIT_SEQ")
	@SequenceGenerator(sequenceName = "AUDIT_SEQ", allocationSize = 1, name = "AUDIT_SEQ")
	@Column(name="AUDIT_ID")
	private long auditId;
	
	@Column(name = "EVENT_NAME", length = 50)
    private String eventName;
	
	@Column(name = "FIELD_NAME")
	private String fieldName;
	
	@Column(name = "CURRENT_VALUE", length = 50)
    private String currentValue;
	
	@Column(name = "MODIFIED_BY", length = 50)
    private String modifiedBy;
	
	@Column(name = "MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
