package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the role_permission_relation database table.
 * 
 */
@Embeddable
public class RolePermissionRelationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String roleId;
	private String permissionEname;

	public RolePermissionRelationPK() {
	}

	@Column(name="role_id", insertable=false, updatable=false)
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name="permission_ename")
	public String getPermissionEname() {
		return this.permissionEname;
	}
	public void setPermissionEname(String permissionEname) {
		this.permissionEname = permissionEname;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolePermissionRelationPK)) {
			return false;
		}
		RolePermissionRelationPK castOther = (RolePermissionRelationPK)other;
		return 
			this.roleId.equals(castOther.roleId)
			&& this.permissionEname.equals(castOther.permissionEname);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleId.hashCode();
		hash = hash * prime + this.permissionEname.hashCode();
		
		return hash;
	}
}