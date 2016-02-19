package com.medic.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


   @Entity
   @Table(name="employee", schema="test")
   public class EmployeeEntity implements Serializable
   {
    private static final long serialVersionUID = 1L;

	@GenericGenerator
	(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="test.employeesequence")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name="id")
	private long id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
    private String lastname;
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Column(name="email")
    private String email;
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
