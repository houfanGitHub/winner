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
 * The persistent class for the member database table.
 * 
 */
@Entity
@Table(name="member")
public class Member  {  //会员表
	private String id;
	private Date createDate;  //创建时间
	private byte delFlag;  //删除标志
	private BigInteger headid; // 头像图片id
	private String identity;//身份证
	private String invitationCode;  //邀请码
	private String invitedCode;  //被邀请码
	private String memberName;  //真实姓名
	private String mobile_Phone;  //手机号
	private String name;   //用户名
	private String password;  //密码
	private String qqAccount;  //QQ账号关联
	private String qqNumber;  //QQ号码
	private String salt;  //密码盐
	private byte status; //账号状态（正常，锁定，删除）
	private Date updateDate; //修改时间
	private String weiBoAccount; //微博账号关联
	private String weixinAccount;  //微信账号关联
	private String withdrawPassword;  //提款密码
	private Set<AssociatedAccount> associatedAccounts = new HashSet<>();
	private Set<BbinInfo> bbinInfos = new HashSet<>();
	private Set<Feedback> feedbacks = new HashSet<>();//意见反馈
	private Set<FinanceProductSubscribe> financeProductSubscribes = new HashSet<>();
	private Set<FinanceProductSubscribeRecord> financeProductSubscribeRecords = new HashSet<>();
	private Set<FinancialPlanner> financialPlanners = new HashSet<>();
	private Set<MemberAccount> memberAccounts = new HashSet<>();
	private Set<MemberBankcard> memberBankcards = new HashSet<>();
	private Set<MemberDepositRecord> memberDepositRecords = new HashSet<>();
	private Set<MemberProfitRecord> memberProfitRecords = new HashSet<>();  //成员利润表
	private Set<MemberPucChargeHome> memberPucChargeHomes = new HashSet<>();
	private Set<MemberPucChargeItem> memberPucChargeItems = new HashSet<>();
	private Set<MemberTally> memberTallies = new HashSet<>();
	private Set<MemberTradeRecord> memberTradeRecords = new HashSet<>();
	private Set<MemberWithdrawRecord> memberWithdrawRecords = new HashSet<>();
	private Set<OverseaConfigSubscribe> overseaConfigSubscribes = new HashSet<>();
	private Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords = new HashSet<>();
	private Set<SubjectOrderRecord> subjectOrderRecords = new HashSet<>();
	private Set<AwardRecord> awardRecords=new HashSet<>();  //邀请奖励表
	
	
	@OneToMany(mappedBy="member")
	public Set<AwardRecord> getAwardRecords() {
		return awardRecords;
	}


	public void setAwardRecords(Set<AwardRecord> awardRecords) {
		this.awardRecords = awardRecords;
	}


	public Member() {
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


	public BigInteger getHeadid() {
		return this.headid;
	}

	public void setHeadid(BigInteger headid) {
		this.headid = headid;
	}


	@Column(length=18)
	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}


	@Column(length=100)
	public String getInvitationCode() {
		return this.invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}


	@Column(length=100)
	public String getInvitedCode() {
		return this.invitedCode;
	}

	public void setInvitedCode(String invitedCode) {
		this.invitedCode = invitedCode;
	}


	@Column(name="member_name", length=32)
	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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


	@Column(length=100)
	public String getQqAccount() {
		return this.qqAccount;
	}

	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}


	@Column(length=100)
	public String getQqNumber() {
		return this.qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
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


	@Column(length=100)
	public String getWeiBoAccount() {
		return this.weiBoAccount;
	}

	public void setWeiBoAccount(String weiBoAccount) {
		this.weiBoAccount = weiBoAccount;
	}


	@Column(length=100)
	public String getWeixinAccount() {
		return this.weixinAccount;
	}

	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}


	@Column(name="withdraw_password", length=32)
	public String getWithdrawPassword() {
		return this.withdrawPassword;
	}

	public void setWithdrawPassword(String withdrawPassword) {
		this.withdrawPassword = withdrawPassword;
	}


	//bi-directional many-to-one association to AssociatedAccount
	@OneToMany(mappedBy="member")
	public Set<AssociatedAccount> getAssociatedAccounts() {
		return this.associatedAccounts;
	}

	public void setAssociatedAccounts(Set<AssociatedAccount> associatedAccounts) {
		this.associatedAccounts = associatedAccounts;
	}


	//bi-directional many-to-one association to BbinInfo
	@OneToMany(mappedBy="member")
	public Set<BbinInfo> getBbinInfos() {
		return this.bbinInfos;
	}

	public void setBbinInfos(Set<BbinInfo> bbinInfos) {
		this.bbinInfos = bbinInfos;
	}


	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="member")
	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}


	//bi-directional many-to-one association to FinanceProductSubscribe
	@OneToMany(mappedBy="member")
	public Set<FinanceProductSubscribe> getFinanceProductSubscribes() {
		return this.financeProductSubscribes;
	}

	public void setFinanceProductSubscribes(Set<FinanceProductSubscribe> financeProductSubscribes) {
		this.financeProductSubscribes = financeProductSubscribes;
	}


	//bi-directional many-to-one association to FinanceProductSubscribeRecord
	@OneToMany(mappedBy="member")
	public Set<FinanceProductSubscribeRecord> getFinanceProductSubscribeRecords() {
		return this.financeProductSubscribeRecords;
	}

	public void setFinanceProductSubscribeRecords(Set<FinanceProductSubscribeRecord> financeProductSubscribeRecords) {
		this.financeProductSubscribeRecords = financeProductSubscribeRecords;
	}


	//bi-directional many-to-one association to FinancialPlanner
	@OneToMany(mappedBy="member")
	public Set<FinancialPlanner> getFinancialPlanners() {
		return this.financialPlanners;
	}

	public void setFinancialPlanners(Set<FinancialPlanner> financialPlanners) {
		this.financialPlanners = financialPlanners;
	}


	//bi-directional many-to-one association to MemberAccount
	@OneToMany(mappedBy="member")
	public Set<MemberAccount> getMemberAccounts() {
		return this.memberAccounts;
	}

	public void setMemberAccounts(Set<MemberAccount> memberAccounts) {
		this.memberAccounts = memberAccounts;
	}


	//bi-directional many-to-one association to MemberBankcard
	@OneToMany(mappedBy="member")
	public Set<MemberBankcard> getMemberBankcards() {
		return this.memberBankcards;
	}

	public void setMemberBankcards(Set<MemberBankcard> memberBankcards) {
		this.memberBankcards = memberBankcards;
	}

	//bi-directional many-to-one association to MemberDepositRecord
	@OneToMany(mappedBy="member")
	public Set<MemberDepositRecord> getMemberDepositRecords() {
		return this.memberDepositRecords;
	}

	public void setMemberDepositRecords(Set<MemberDepositRecord> memberDepositRecords) {
		this.memberDepositRecords = memberDepositRecords;
	}

	//bi-directional many-to-one association to MemberProfitRecord
	@OneToMany(mappedBy="member")
	public Set<MemberProfitRecord> getMemberProfitRecords() {
		return this.memberProfitRecords;
	}

	public void setMemberProfitRecords(Set<MemberProfitRecord> memberProfitRecords) {
		this.memberProfitRecords = memberProfitRecords;
	}

	//bi-directional many-to-one association to MemberPucChargeHome
	@OneToMany(mappedBy="member")
	public Set<MemberPucChargeHome> getMemberPucChargeHomes() {
		return this.memberPucChargeHomes;
	}

	public void setMemberPucChargeHomes(Set<MemberPucChargeHome> memberPucChargeHomes) {
		this.memberPucChargeHomes = memberPucChargeHomes;
	}

	//bi-directional many-to-one association to MemberPucChargeItem
	@OneToMany(mappedBy="member")
	public Set<MemberPucChargeItem> getMemberPucChargeItems() {
		return this.memberPucChargeItems;
	}

	public void setMemberPucChargeItems(Set<MemberPucChargeItem> memberPucChargeItems) {
		this.memberPucChargeItems = memberPucChargeItems;
	}

	//bi-directional many-to-one association to MemberTally
	@OneToMany(mappedBy="member")
	public Set<MemberTally> getMemberTallies() {
		return this.memberTallies;
	}

	public void setMemberTallies(Set<MemberTally> memberTallies) {
		this.memberTallies = memberTallies;
	}


	//bi-directional many-to-one association to MemberTradeRecord
	@OneToMany(mappedBy="member")
	public Set<MemberTradeRecord> getMemberTradeRecords() {
		return this.memberTradeRecords;
	}

	public void setMemberTradeRecords(Set<MemberTradeRecord> memberTradeRecords) {
		this.memberTradeRecords = memberTradeRecords;
	}


	//bi-directional many-to-one association to MemberWithdrawRecord
	@OneToMany(mappedBy="member")
	public Set<MemberWithdrawRecord> getMemberWithdrawRecords() {
		return this.memberWithdrawRecords;
	}

	public void setMemberWithdrawRecords(Set<MemberWithdrawRecord> memberWithdrawRecords) {
		this.memberWithdrawRecords = memberWithdrawRecords;
	}


	//bi-directional many-to-one association to OverseaConfigSubscribe
	@OneToMany(mappedBy="member")
	public Set<OverseaConfigSubscribe> getOverseaConfigSubscribes() {
		return this.overseaConfigSubscribes;
	}

	public void setOverseaConfigSubscribes(Set<OverseaConfigSubscribe> overseaConfigSubscribes) {
		this.overseaConfigSubscribes = overseaConfigSubscribes;
	}


	//bi-directional many-to-one association to SubjectBbinPurchaseRecord
	@OneToMany(mappedBy="member")
	public Set<SubjectBbinPurchaseRecord> getSubjectBbinPurchaseRecords() {
		return this.subjectBbinPurchaseRecords;
	}

	public void setSubjectBbinPurchaseRecords(Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords) {
		this.subjectBbinPurchaseRecords = subjectBbinPurchaseRecords;
	}


	//bi-directional many-to-one association to SubjectOrderRecord
	@OneToMany(mappedBy="member")
	public Set<SubjectOrderRecord> getSubjectOrderRecords() {
		return this.subjectOrderRecords;
	}

	public void setSubjectOrderRecords(Set<SubjectOrderRecord> subjectOrderRecords) {
		this.subjectOrderRecords = subjectOrderRecords;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", createDate=" + createDate + ", delFlag="
				+ delFlag + ", headid=" + headid + ", identity=" + identity
				+ ", invitationCode=" + invitationCode + ", invitedCode="
				+ invitedCode + ", memberName=" + memberName
				+ ", mobile_Phone=" + mobile_Phone + ", name=" + name
				+ ", password=" + password + ", qqAccount=" + qqAccount
				+ ", qqNumber=" + qqNumber + ", salt=" + salt + ", status="
				+ status + ", updateDate=" + updateDate + ", weiBoAccount="
				+ weiBoAccount + ", weixinAccount=" + weixinAccount
				+ ", withdrawPassword=" + withdrawPassword
				+ ", associatedAccounts=" + associatedAccounts + ", bbinInfos="
				+ bbinInfos + ", feedbacks=" + feedbacks
				+ ", financeProductSubscribes=" + financeProductSubscribes
				+ ", financeProductSubscribeRecords="
				+ financeProductSubscribeRecords + ", financialPlanners="
				+ financialPlanners + ", memberAccounts=" + memberAccounts
				+ ", memberBankcards=" + memberBankcards
				+ ", memberDepositRecords=" + memberDepositRecords
				+ ", memberProfitRecords=" + memberProfitRecords
				+ ", memberPucChargeHomes=" + memberPucChargeHomes
				+ ", memberPucChargeItems=" + memberPucChargeItems
				+ ", memberTallies=" + memberTallies + ", memberTradeRecords="
				+ memberTradeRecords + ", memberWithdrawRecords="
				+ memberWithdrawRecords + ", overseaConfigSubscribes="
				+ overseaConfigSubscribes + ", subjectBbinPurchaseRecords="
				+ subjectBbinPurchaseRecords + ", subjectOrderRecords="
				+ subjectOrderRecords + "]";
	}

}