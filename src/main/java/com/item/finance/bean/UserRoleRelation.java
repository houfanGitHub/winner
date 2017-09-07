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
 * The persistent class for the user_role_relation database table.
 * 用户角色关联表
 */
@Entity
@Table(name="user_role_relation")
@NamedQuery(name="UserRoleRelation.findAll", query="SELECT u FROM UserRoleRelation u")
public class UserRoleRelation  {
	
	private UserRoleRelationPK id;
	private Date createDate;
	private UserRole userRole;

	public UserRoleRelation() {
	}


	@EmbeddedId
	public UserRoleRelationPK getId() {
		return this.id;
	}

	public void setId(UserRoleRelationPK id) {
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