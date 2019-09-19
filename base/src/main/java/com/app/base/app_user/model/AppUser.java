package com.app.base.app_user.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.base.user_profile.model.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="appuser", schema="db_security")
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Solves "No serializer found" error
public class AppUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(
		mappedBy = "user",
		cascade = CascadeType.ALL,
		orphanRemoval = true,
		fetch = FetchType.EAGER
		)
	@JsonIgnore
	private UserProfile userProfile;

}
