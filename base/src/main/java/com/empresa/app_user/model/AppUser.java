package com.empresa.app_user.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.empresa.user_profile.model.UserProfile;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="appuser", schema="db_security")
@Getter @Setter
public class AppUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserProfile userProfile;
	
	
	// @Column(name = "order")
	// private Order order;
	
	/*
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name="user_role",
			joinColumns= {@JoinColumn(name="user_id", referencedColumnName="user_id")},
			inverseJoinColumns= {@JoinColumn(name="role_id", referencedColumnName="role_id")}
			)
	private List<Role> roles;
	*/

	/*
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	*/

	/*
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		
		for (Role role:roles) {
			list.add(new SimpleGrantedAuthority(role.getRolename()));			
		}		
		return list;
	}*/


}
