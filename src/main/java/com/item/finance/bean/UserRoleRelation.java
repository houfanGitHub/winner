package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the user_role_relation database table.
 * 
 */
@Entity
@Table(name="user_role_relation")
public class UserRoleRelation  {
	
	private String id;
	private User user;
	private UserRole userRole;
	private Date createDate;

	public UserRoleRelation() {
		
	}
	
	
	public UserRoleRelation(User user, UserRole userRole, Date createDate) {
		super();
		this.user = user;
		this.userRole = userRole;
		this.createDate = createDate;
	}
	
	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@ManyToOne/*(fetch=FetchType.LAZY)*/
	@JoinColumn(name="role_id")
	public UserRole getUserRole() {
		return userRole;
	}


	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}