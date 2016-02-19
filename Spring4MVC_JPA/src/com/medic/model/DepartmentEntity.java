package com.medic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="department", schema="test")
public class DepartmentEntity implements Serializable
{


	private static final long serialVersionUID = 1L;
	@GenericGenerator
	(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="test.employeesequence")})
	@Id
	@GeneratedValue(generator = "sequence")
	
	@Column(name="id")
	private long id;
	
	@Column(name="deptname")
    private String deptname;
	
    public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	 
    
    
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
