package com.security.model;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User_Role_Id implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6667544753391594388L;
	
	private Long userpk;
	
	private Long rolepk;
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if (o == null || o.getClass() != this.getClass())
			return false;
		
		User_Role user_role = (User_Role) o;
		
		return (user_role.getRolepk() == this.rolepk && user_role.getUserpk() == this.userpk);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getUserpk(), getRolepk());
	}
	

}
