package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the role_permission_relation database table.
 * 角色表对应的权限表
 */
@Entity
@Table(name="role_permission_relation")
@NamedQuery(name="RolePermissionRelation.findAll", query="SELECT r FROM RolePermissionRelation r")
public class RolePermissionRelation  {

	private RolePermissionRelationPK id;
	private Date createDate;
	private UserRole userRole;

	public RolePermissionRelation() {
	}


	@EmbeddedId
	public RolePermissionRelationPK getId() {
		return this.id;
	}

	public void setId(RolePermissionRelationPK id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	//bi-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="role_id")
	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}