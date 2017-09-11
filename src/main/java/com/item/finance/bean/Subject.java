package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@Table(name="subject")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject  {
	private static final long serialVersionUID = 1L;
	private String id;//主键ID
	private BigDecimal amount;
	private BigInteger borrowerid;//借款人id
	private String borrowername; //借款人姓名
	private BigInteger bought;
	private String comment; //产品速览
	private Date createDate; //创建日期
	private byte delflag; //是否删除
	private Date endDate; //标的结束日期
	private BigInteger experStatus;// 体验金是否可以购买（0：否，1：是）
	private BigInteger firstId;
	private BigDecimal floorAmount;
	private String name;
	private BigInteger parentId;
	private BigInteger period;
	private String projectDetails;
	private String purpose;
	private Date raiseEnd;
	private Date raiseStart;
	private byte refundWay;
	private byte safeGuard_way;
	private String safetyControl;
	private String serialNo;
	private String serialNumber;
	private Date startDate; //标的开始日期
	private byte status; //标的状态
	private byte type; //标的类型
	private Date updateDate; //更新日期
	private BigDecimal yearRate; //年化率
	private SubjectFolder subjectFolder;
	private Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords = new HashSet<>();
	private Set<SubjectFieldRecord> subjectFieldRecords = new HashSet<>();
	private Set<SubjectOrderRecord> subjectOrderRecords = new HashSet<>();

	public Subject() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(precision=10, scale=2)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public BigInteger getBorrowerid() {
		return this.borrowerid;
	}

	public void setBorrowerid(BigInteger borrowerid) {
		this.borrowerid = borrowerid;
	}


	@Column(length=100)
	public String getBorrowername() {
		return this.borrowername;
	}

	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}


	public BigInteger getBought() {
		return this.bought;
	}

	public void setBought(BigInteger bought) {
		this.bought = bought;
	}


	@Lob
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Column(name="exper_status")
	public BigInteger getExperStatus() {
		return this.experStatus;
	}

	public void setExperStatus(BigInteger experStatus) {
		this.experStatus = experStatus;
	}


	@Column(name="first_id")
	public BigInteger getFirstId() {
		return this.firstId;
	}

	public void setFirstId(BigInteger firstId) {
		this.firstId = firstId;
	}


	@Column(name="floor_amount", precision=10, scale=4)
	public BigDecimal getFloorAmount() {
		return this.floorAmount;
	}

	public void setFloorAmount(BigDecimal floorAmount) {
		this.floorAmount = floorAmount;
	}


	@Column(length=500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="parent_id")
	public BigInteger getParentId() {
		return this.parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}


	public BigInteger getPeriod() {
		return this.period;
	}

	public void setPeriod(BigInteger period) {
		this.period = period;
	}


	@Lob
	public String getProjectDetails() {
		return this.projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}


	@Column(length=500)
	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="raise_end")
	public Date getRaiseEnd() {
		return this.raiseEnd;
	}

	public void setRaiseEnd(Date raiseEnd) {
		this.raiseEnd = raiseEnd;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="raise_start")
	public Date getRaiseStart() {
		return this.raiseStart;
	}

	public void setRaiseStart(Date raiseStart) {
		this.raiseStart = raiseStart;
	}


	@Column(name="refund_way")
	public byte getRefundWay() {
		return this.refundWay;
	}

	public void setRefundWay(byte refundWay) {
		this.refundWay = refundWay;
	}


	public byte getSafeGuard_way() {
		return this.safeGuard_way;
	}

	public void setSafeGuard_way(byte safeGuard_way) {
		this.safeGuard_way = safeGuard_way;
	}


	@Lob
	public String getSafetyControl() {
		return this.safetyControl;
	}

	public void setSafetyControl(String safetyControl) {
		this.safetyControl = safetyControl;
	}


	@Column(name="serial_no", length=50)
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}


	@Column(name="serial_number", length=50)
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}


	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="year_rate", precision=10, scale=4)
	public BigDecimal getYearRate() {
		return this.yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}


	//bi-directional many-to-one association to SubjectFolder
	@ManyToOne
	@JoinColumn(name="folder_id")
	public SubjectFolder getSubjectFolder() {
		return this.subjectFolder;
	}

	public void setSubjectFolder(SubjectFolder subjectFolder) {
		this.subjectFolder = subjectFolder;
	}


	//bi-directional many-to-one association to SubjectBbinPurchaseRecord
	@OneToMany(mappedBy="subject")
	public Set<SubjectBbinPurchaseRecord> getSubjectBbinPurchaseRecords() {
		return this.subjectBbinPurchaseRecords;
	}

	public void setSubjectBbinPurchaseRecords(Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords) {
		this.subjectBbinPurchaseRecords = subjectBbinPurchaseRecords;
	}

	public SubjectBbinPurchaseRecord addSubjectBbinPurchaseRecord(SubjectBbinPurchaseRecord subjectBbinPurchaseRecord) {
		getSubjectBbinPurchaseRecords().add(subjectBbinPurchaseRecord);
		subjectBbinPurchaseRecord.setSubject(this);

		return subjectBbinPurchaseRecord;
	}

	public SubjectBbinPurchaseRecord removeSubjectBbinPurchaseRecord(SubjectBbinPurchaseRecord subjectBbinPurchaseRecord) {
		getSubjectBbinPurchaseRecords().remove(subjectBbinPurchaseRecord);
		subjectBbinPurchaseRecord.setSubject(null);

		return subjectBbinPurchaseRecord;
	}


	//bi-directional many-to-one association to SubjectFieldRecord
	@OneToMany(mappedBy="subject")
	public Set<SubjectFieldRecord> getSubjectFieldRecords() {
		return this.subjectFieldRecords;
	}

	public void setSubjectFieldRecords(Set<SubjectFieldRecord> subjectFieldRecords) {
		this.subjectFieldRecords = subjectFieldRecords;
	}

	public SubjectFieldRecord addSubjectFieldRecord(SubjectFieldRecord subjectFieldRecord) {
		getSubjectFieldRecords().add(subjectFieldRecord);
		subjectFieldRecord.setSubject(this);

		return subjectFieldRecord;
	}

	public SubjectFieldRecord removeSubjectFieldRecord(SubjectFieldRecord subjectFieldRecord) {
		getSubjectFieldRecords().remove(subjectFieldRecord);
		subjectFieldRecord.setSubject(null);

		return subjectFieldRecord;
	}


	//bi-directional many-to-one association to SubjectOrderRecord
	@OneToMany(mappedBy="subject")
	public Set<SubjectOrderRecord> getSubjectOrderRecords() {
		return this.subjectOrderRecords;
	}

	public void setSubjectOrderRecords(Set<SubjectOrderRecord> subjectOrderRecords) {
		this.subjectOrderRecords = subjectOrderRecords;
	}

	public SubjectOrderRecord addSubjectOrderRecord(SubjectOrderRecord subjectOrderRecord) {
		getSubjectOrderRecords().add(subjectOrderRecord);
		subjectOrderRecord.setSubject(this);

		return subjectOrderRecord;
	}

	public SubjectOrderRecord removeSubjectOrderRecord(SubjectOrderRecord subjectOrderRecord) {
		getSubjectOrderRecords().remove(subjectOrderRecord);
		subjectOrderRecord.setSubject(null);

		return subjectOrderRecord;
	}

}