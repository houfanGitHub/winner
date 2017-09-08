package com.item.finance.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the user_login_token database table.
 * 用户登陆令牌表
 */
@Entity
@Table(name="user_login_token")
public class UserLoginToken  {
	
	private String token;	//令牌号
	private Date createDate;	//创建时间
	private Date expireTime;	//有效时间
	private String password;	//密码
	private Date updateDate;	//修改时间
	private String userName;	//登录时的用户名，可以是用户名，手机号等
	private User user;	//用户

	public UserLoginToken() {
	}


	@Id
	@Column(unique=true, nullable=false, length=64)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expire_time", nullable=false)
	public Date getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}


	@Column(nullable=false, length=128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="user_name", nullable=false, length=128)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}