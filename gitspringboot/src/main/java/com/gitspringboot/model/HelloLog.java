package com.gitspringboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="hellolog")
public class HelloLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HELLO_SEQ")
    @SequenceGenerator(sequenceName = "hello_seq", allocationSize = 1, name = "HELLO_SEQ")
	@NotNull
	@Column(name="uids", unique=true)
	private int uid;
	
	@Column(name="names")
	private String name;
	
	@NotNull
	@Column(name="timestamps")
	private Date timestamps;
	
	public HelloLog() {}
	public HelloLog(String name) {
		
		this.name = name;
		this.timestamps = new Date();
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
	public Date getTimestamps() {
		return timestamps;
	}
	public void setTimestamps(Date timestamp) {
		this.timestamps = timestamp;
	}
	
	
	
}
