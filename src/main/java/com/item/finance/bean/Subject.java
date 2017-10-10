package com.item.finance.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@Table(name="subject")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject  {
	

	private static final long serialVersionUID = 1L;
	private int id;//主键ID
	private double amount; //标的金额
	private int borrowerid;//借款人id
	private String borrowername; //借款人姓名
	private int bought; //已购人数
	private String comment; //产品速览
	private String createDate; //创建日期
	private byte delflag; //是否删除

	private String endDate; //标的结束日期
	private int experStatus;// 体验金是否可以购买（0：否，1：是）
	private int firstId; //始标id
	private double floorAmount; //起投金额
	private String name;  //标的名称
	private int parentId; //父标id
	private int period; //标的周期
	private String projectDetails; //项目详情
	private String purpose; //借款目的
	private Date raiseEnd; //募集结束
	private Date raiseStart; //募集开始
	private byte refundWay; //还款方式  (0 分期还本付息    ； 1 一次性还本付息)
	private byte safeGuard_way; //保障方式
	private String safetyControl;//安全保障
	private String serialNo;//合同号        
	private String serialNumber; //流水号
	private String startDate; //标的开始日期
	private byte status; //标的状态
	private byte type; //标的类型
	private String updateDate; //更新日期
	private double yearRate; //年化率
	//private long yearEarnings;//年化收益
	private SubjectFolder subjectFolder;//附件归属表
	private Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords = new HashSet<>();//体验金购买标的表
	private Set<SubjectFieldRecord> subjectFieldRecords = new HashSet<>();//主题记录表
	private Set<SubjectOrderRecord> subjectOrderRecords = new HashSet<>();//标的订单表
	public Subject() {
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	/*public void setYearEarnings(long yearEarnings) {
		this.yearEarnings = yearEarnings;
	}
	public long getYearEarnings() {
		//收益=本金*年利率/365*天数
				double a=this.getFloorAmount();//本金
				double b=this.getYearRate();//年化率
				double c=this.getPeriod();//天数
				double d=double.valueOf(365);
				DecimalFormat dbf=new DecimalFormat("0.00");
				String yearEarnings1=dbf.format(a.add(b).divide(d).multiply(c));
				 yearEarnings=Long.valueOf(yearEarnings1);
				System.out.println("yearEarnings2:"+yearEarnings);
		      return yearEarnings;
	}*/


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Column(precision=10, scale=2)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getBorrowerid() {
		return this.borrowerid;
	}

	public void setBorrowerid(int borrowerid) {
		this.borrowerid = borrowerid;
	}


	@Column(length=100)
	public String getBorrowername() {
		return this.borrowername;
	}

	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}


	public int getBought() {
		return this.bought;
	}

	public void setBought(int bought) {
		this.bought = bought;
	}


	@Lob
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String string) {
		this.createDate = string;
	}


	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	@Column(name="exper_status")
	public int getExperStatus() {
		return this.experStatus;
	}

	public void setExperStatus(int experStatus) {
		this.experStatus = experStatus;
	}


	@Column(name="first_id")
	public int getFirstId() {
		return this.firstId;
	}

	public void setFirstId(int firstId) {
		this.firstId = firstId;
	}


	@Column(name="floor_amount", precision=10, scale=4)
	public double getFloorAmount() {
		return this.floorAmount;
	}

	public void setFloorAmount(double floorAmount) {
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
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getPeriod() {
		return period;
	}



	public void setPeriod(int period) {
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


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
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


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="year_rate", precision=10, scale=4)
	public double getYearRate() {
		return this.yearRate;
	}
	public void setYearRate(double yearRate) {
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
