package com.dp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="certusers")
public class Certusers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Certusers(){
		
	}
	//@Column(name="id",nullable=false)
	private int id;
	
	@Id
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="pass",nullable=false)
	private String pass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	
	

}
