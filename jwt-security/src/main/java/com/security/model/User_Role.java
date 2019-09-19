package com.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_role", schema="db_security")
@IdClass(User_Role_Id.class)
@Getter @Setter
public class User_Role {
	
	@Id
	@Column(name="userpk")
	private Long userpk;
	
	@Id
	@Column(name="rolepk")
	private Long rolepk;
	
	public User_Role() { }	
	
	public User_Role(Long userpk, Long rolepk) {
		this.userpk = userpk;
		this.rolepk = rolepk;
	}

}
