package com.item.finance.bean;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the user_role database table.
 * 角色表
 */
@Entity
@Table(name="user_role")
public class UserRole  {
	
	private String id;		//主键
	private byte available;	//是否可用
	private String category;	//分类
	private String cname;	//中文名
	private Date createDate;	//创建时间
	private byte delFlag;	//是否删除
	private String ename;	//英文名
	private String remark;	//备注
	private BigInteger sourceId;	//源ID
	private byte sourceType;	// 源型类别
	private Date updateDate; 	//修改时间
	private Set<RolePermissionRelation> rolePermissionRelations = new HashSet<>();

	public UserRole() {
	}


	@Id
	@GeneratedValue
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public byte getAvailable() {
		return this.available;
	}

	public void setAvailable(byte available) {
		this.available = available;
	}


	@Column(length=32)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Column(length=32)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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


	@Column(length=32)
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	@Column(length=256)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Column(name="source_id")
	public BigInteger getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(BigInteger sourceId) {
		this.sourceId = sourceId;
	}


	@Column(name="source_type")
	public byte getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(byte sourceType) {
		this.sourceType = sourceType;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	//bi-directional many-to-one association to RolePermissionRelation
	@OneToMany(mappedBy="userRole")
	public Set<RolePermissionRelation> getRolePermissionRelations() {
		return this.rolePermissionRelations;
	}

	public void setRolePermissionRelations(Set<RolePermissionRelation> rolePermissionRelations) {
		this.rolePermissionRelations = rolePermissionRelations;
	}


	@Override
	public String toString() {
		return "UserRole [id=" + id + ", available=" + available
				+ ", category=" + category + ", cname=" + cname
				+ ", createDate=" + createDate + ", delFlag=" + delFlag
				+ ", ename=" + ename + ", remark=" + remark + ", sourceId="
				+ sourceId + ", sourceType=" + sourceType + ", updateDate="
				+ updateDate + ", rolePermissionRelations="
				+ rolePermissionRelations + "]";
	}

}