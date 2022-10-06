package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import net.javaguides.springboot.annotations.TaxValidation;



@Table(name="users")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@TaxValidation
	@Column(unique = true)
	private String taxno;
	
	@NotEmpty
	@Email
	private String email;
	
	public User() {
		
	}
	
	public User(String taxno, String email) {
		super();
		this.taxno = taxno;
		this.email = email;
	}


	public String getTaxno() {
		return taxno;
	}
	public void setTaxno(String taxno) {
		this.taxno = taxno;
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
