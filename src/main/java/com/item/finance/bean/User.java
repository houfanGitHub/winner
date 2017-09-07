package com.item.finance.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the users database table.
 * 用户基本表
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User  {
	
	private String id;
	private Date createDate;
	private byte delFlag;
	private byte identity;
	private String mobile_Phone;
	private String name;
	private String password;
	private String salt;
	private byte status;
	private Date updateDate;
	private String userName;
	private Set<UserLoginToken> userLoginTokens;

	public User() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
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


	@Column(name="del_flag")
	public byte getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(byte delFlag) {
		this.delFlag = delFlag;
	}


	public byte getIdentity() {
		return this.identity;
	}

	public void setIdentity(byte identity) {
		this.identity = identity;
	}


	public String getMobile_Phone() {
		return this.mobile_Phone;
	}

	public void setMobile_Phone(String mobile_Phone) {
		this.mobile_Phone = mobile_Phone;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	//bi-directional many-to-one association to UserLoginToken
	@OneToMany(mappedBy="user")
	public Set<UserLoginToken> getUserLoginTokens() {
		return this.userLoginTokens;
	}

	public void setUserLoginTokens(Set<UserLoginToken> userLoginTokens) {
		this.userLoginTokens = userLoginTokens;
	}

	public UserLoginToken addUserLoginToken(UserLoginToken userLoginToken) {
		getUserLoginTokens().add(userLoginToken);
		userLoginToken.setUser(this);

		return userLoginToken;
	}

	public UserLoginToken removeUserLoginToken(UserLoginToken userLoginToken) {
		getUserLoginTokens().remove(userLoginToken);
		userLoginToken.setUser(null);

		return userLoginToken;
	}

}