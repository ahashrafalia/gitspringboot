package com.gitspringboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="hellolog")
public class HelloLog {

	@Id
	@GeneratedValue
	@NotNull
	@Column(name="uid", unique=true)
	private int uid;
	
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="timestamp")
	private Date timestamp;
	
	public HelloLog() {}
	public HelloLog(String name) {
		
		this.name = name;
		this.timestamp = new Date();
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
