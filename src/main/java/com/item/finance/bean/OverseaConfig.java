package com.item.finance.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the oversea_config database table.
 * 
 */
@Entity
@Table(name="oversea_config")
public class OverseaConfig  {//海外配置订阅表
	
	private String id;//id
	private Date addTime;//添加时间
	private String childTitle;//子标题
	private String content;//内容
	private int sortColum;//排序值
	private String description;//描述
	private Date endDate;//结束时间
	private String overseaIcon;//图标
	private Date startDate;//开始时间
	private int status;//状态
	private String title;//标题
	private Date updTime;//修改时间
	private String userType;//用户群体
	private Set<OverseaConfigSubscribe> overseaConfigSubscribes = new HashSet<>();//海外配置订阅表

	public OverseaConfig() {
	}

//排序值
	public int getSortColum() {
		return sortColum;
	}

	public void setSortColum(int sortColum) {
		this.sortColum = sortColum;
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	@Column(name="child_title", length=128)
	public String getChildTitle() {
		return this.childTitle;
	}

	public void setChildTitle(String childTitle) {
		this.childTitle = childTitle;
	}


	@Lob
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Column(length=255)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Column(name="oversea_icon", length=200)
	public String getOverseaIcon() {
		return this.overseaIcon;
	}

	public void setOverseaIcon(String overseaIcon) {
		this.overseaIcon = overseaIcon;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Column(length=255)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdTime() {
		return this.updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}


	@Column(name="user_type", length=128)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	//bi-directional many-to-one association to OverseaConfigSubscribe
	@OneToMany(mappedBy="overseaConfig")
	public Set<OverseaConfigSubscribe> getOverseaConfigSubscribes() {
		return this.overseaConfigSubscribes;
	}

	public void setOverseaConfigSubscribes(Set<OverseaConfigSubscribe> overseaConfigSubscribes) {
		this.overseaConfigSubscribes = overseaConfigSubscribes;
	}

}