package com.item.finance.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the oversea_config database table.
 * 海外配置表
 */
@Entity
@Table(name="oversea_config")
@NamedQuery(name="OverseaConfig.findAll", query="SELECT o FROM OverseaConfig o")
public class OverseaConfig  {

	private String id;
	private Date addTime;
	private String childTitle;
	private String content;
	private String description;
	private Date endDate;
	private String overseaIcon;
	private int sortColum;
	private Date startDate;
	private int status;
	private String title;
	private Date updTime;
	private String userType;
	private Set<OverseaConfigSubscribe> overseaConfigSubscribes;

	public OverseaConfig() {
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
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	@Column(name="child_title")
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


	@Column(name="oversea_icon")
	public String getOverseaIcon() {
		return this.overseaIcon;
	}

	public void setOverseaIcon(String overseaIcon) {
		this.overseaIcon = overseaIcon;
	}


	public int getSortColum() {
		return this.sortColum;
	}

	public void setSortColum(int sortColum) {
		this.sortColum = sortColum;
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


	@Column(name="user_type")
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

	public OverseaConfigSubscribe addOverseaConfigSubscribe(OverseaConfigSubscribe overseaConfigSubscribe) {
		getOverseaConfigSubscribes().add(overseaConfigSubscribe);
		overseaConfigSubscribe.setOverseaConfig(this);

		return overseaConfigSubscribe;
	}

	public OverseaConfigSubscribe removeOverseaConfigSubscribe(OverseaConfigSubscribe overseaConfigSubscribe) {
		getOverseaConfigSubscribes().remove(overseaConfigSubscribe);
		overseaConfigSubscribe.setOverseaConfig(null);

		return overseaConfigSubscribe;
	}

}