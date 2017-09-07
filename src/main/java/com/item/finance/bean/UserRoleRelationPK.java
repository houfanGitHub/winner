package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the user_role_relation database table.
 * 
 */
@Embeddable
public class UserRoleRelationPK implements Serializable {
	//default serial version id, required for serializable classes.
	
	private String userId;
	private String roleId;

	public UserRoleRelationPK() {
	}

	@Column(name="user_id")
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="role_id", insertable=false, updatable=false)
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserRoleRelationPK)) {
			return false;
		}
		UserRoleRelationPK castOther = (UserRoleRelationPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.roleId.equals(castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.roleId.hashCode();
		
		return hash;
	}
}