package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the role_permission_relation database table.
 * 
 */
@Entity
@Table(name="role_permission_relation")
public class RolePermissionRelation  {
	private String id;
	private String pername;
	private Date createDate;
	private UserRole userRole;

	public RolePermissionRelation() {
	}

	public RolePermissionRelation(String pername, Date createDate,
			UserRole userRole) {
		super();
		this.pername = pername;
		this.createDate = createDate;
		this.userRole = userRole;
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
	@JoinColumn(name="role_id", nullable=false)
	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}


	@Column(name="permission_ename")
	public String getPername() {
		return pername;
	}


	public void setPername(String pername) {
		this.pername = pername;
	}

	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

}