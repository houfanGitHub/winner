package com.item.finance.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class User  {

	private String id;	//用户id
	private Date createDate;	//创建时间
	private byte delFlag;	//删除标志
	private String identity;	//身份
	private String mobile_Phone;	//手机号
	private String name;	//名称
	private String password;	//密码
	private String salt;	//密码盐
	private byte status;	//账号状态(正常，锁定，删除)
	private Date updateDate;	//修改时间
	private String userName;	//用户名
	private Set<UserRoleRelation> userRoleRelations = new HashSet<>();

	public User() {
	}

	@Id
	@GeneratedValue
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


	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Column(length=32)
	public String getMobile_Phone() {
		return this.mobile_Phone;
	}

	public void setMobile_Phone(String mobile_Phone) {
		this.mobile_Phone = mobile_Phone;
	}


	@Column(length=32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(length=256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(length=32)
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


	@Column(name="user_name", length=32)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", createDate=" + createDate + ", delFlag="
				+ delFlag + ", identity=" + identity + ", mobile_Phone="
				+ mobile_Phone + ", name=" + name + ", password=" + password
				+ ", salt=" + salt + ", status=" + status + ", updateDate="
				+ updateDate + ", userName=" + userName + "]";
	}

	@OneToMany(mappedBy="user")
	public Set<UserRoleRelation> getUserRoleRelations() {
		return userRoleRelations;
	}

	public void setUserRoleRelations(Set<UserRoleRelation> userRoleRelations) {
		this.userRoleRelations = userRoleRelations;
	}

}