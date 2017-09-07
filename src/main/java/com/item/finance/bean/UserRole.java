package com.item.finance.bean;

import java.math.BigInteger;
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
 * The persistent class for the user_role database table.
 * 角色表
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole  {

	private String id;
	private byte available;
	private String category;
	private String cname;
	private Date createDate;
	private byte delFlag;
	private String ename;
	private String remark;
	private BigInteger sourceId;
	private byte sourceType;
	private Date updateDate;
	private Set<RolePermissionRelation> rolePermissionRelations;
	private Set<UserRoleRelation> userRoleRelations;

	public UserRole() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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


	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


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


	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


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

	public RolePermissionRelation addRolePermissionRelation(RolePermissionRelation rolePermissionRelation) {
		getRolePermissionRelations().add(rolePermissionRelation);
		rolePermissionRelation.setUserRole(this);

		return rolePermissionRelation;
	}

	public RolePermissionRelation removeRolePermissionRelation(RolePermissionRelation rolePermissionRelation) {
		getRolePermissionRelations().remove(rolePermissionRelation);
		rolePermissionRelation.setUserRole(null);

		return rolePermissionRelation;
	}


	//bi-directional many-to-one association to UserRoleRelation
	@OneToMany(mappedBy="userRole")
	public Set<UserRoleRelation> getUserRoleRelations() {
		return this.userRoleRelations;
	}

	public void setUserRoleRelations(Set<UserRoleRelation> userRoleRelations) {
		this.userRoleRelations = userRoleRelations;
	}

	public UserRoleRelation addUserRoleRelation(UserRoleRelation userRoleRelation) {
		getUserRoleRelations().add(userRoleRelation);
		userRoleRelation.setUserRole(this);

		return userRoleRelation;
	}

	public UserRoleRelation removeUserRoleRelation(UserRoleRelation userRoleRelation) {
		getUserRoleRelations().remove(userRoleRelation);
		userRoleRelation.setUserRole(null);

		return userRoleRelation;
	}

}