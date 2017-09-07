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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the member database table.
 * 用户基本表
 */
@Entity
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member  {
	
	private String id;
	private Date createDate;
	private byte delFlag;
	private BigInteger headid;
	private String identity;
	private String invitationCode;
	private String invitedCode;
	private String memberName;
	private String mobile_Phone;
	private String name;
	private String password;
	private String qqAccount;
	private String qqNumber;
	private String salt;
	private byte status;
	private Date updateDate;
	private String weiBoAccount;
	private String weixinAccount;
	private String withdrawPassword;
	private Set<AssociatedAccount> associatedAccounts;
	private Set<BbinInfo> bbinInfos;
	private Set<FinanceProductSubscribe> financeProductSubscribes;
	private Set<FinancialPlanner> financialPlanners;
	private Set<MemberAccount> memberAccounts;
	private Set<MemberBankcard> memberBankcards;
	private Set<MemberDepositRecord> memberDepositRecords;
	private Set<MemberProfitRecord> memberProfitRecords;
	private Set<MemberPucChargeHome> memberPucChargeHomes;
	private Set<MemberWithdrawRecord> memberWithdrawRecords;
	private Set<OverseaConfigSubscribe> overseaConfigSubscribes;
	private Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords;
	private Set<SubjectOrderRecord> subjectOrderRecords;
	private Set<SubjectPurchaseRecord> subjectPurchaseRecords;

	public Member() {
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


	public BigInteger getHeadid() {
		return this.headid;
	}

	public void setHeadid(BigInteger headid) {
		this.headid = headid;
	}


	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public String getInvitationCode() {
		return this.invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}


	public String getInvitedCode() {
		return this.invitedCode;
	}

	public void setInvitedCode(String invitedCode) {
		this.invitedCode = invitedCode;
	}


	@Column(name="member_name")
	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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


	public String getQqAccount() {
		return this.qqAccount;
	}

	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}


	public String getQqNumber() {
		return this.qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
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


	public String getWeiBoAccount() {
		return this.weiBoAccount;
	}

	public void setWeiBoAccount(String weiBoAccount) {
		this.weiBoAccount = weiBoAccount;
	}


	public String getWeixinAccount() {
		return this.weixinAccount;
	}

	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}


	@Column(name="withdraw_password")
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

	public AssociatedAccount addAssociatedAccount(AssociatedAccount associatedAccount) {
		getAssociatedAccounts().add(associatedAccount);
		associatedAccount.setMember(this);

		return associatedAccount;
	}

	public AssociatedAccount removeAssociatedAccount(AssociatedAccount associatedAccount) {
		getAssociatedAccounts().remove(associatedAccount);
		associatedAccount.setMember(null);

		return associatedAccount;
	}


	//bi-directional many-to-one association to BbinInfo
	@OneToMany(mappedBy="member")
	public Set<BbinInfo> getBbinInfos() {
		return this.bbinInfos;
	}

	public void setBbinInfos(Set<BbinInfo> bbinInfos) {
		this.bbinInfos = bbinInfos;
	}

	public BbinInfo addBbinInfo(BbinInfo bbinInfo) {
		getBbinInfos().add(bbinInfo);
		bbinInfo.setMember(this);

		return bbinInfo;
	}

	public BbinInfo removeBbinInfo(BbinInfo bbinInfo) {
		getBbinInfos().remove(bbinInfo);
		bbinInfo.setMember(null);

		return bbinInfo;
	}


	//bi-directional many-to-one association to FinanceProductSubscribe
	@OneToMany(mappedBy="member")
	public Set<FinanceProductSubscribe> getFinanceProductSubscribes() {
		return this.financeProductSubscribes;
	}

	public void setFinanceProductSubscribes(Set<FinanceProductSubscribe> financeProductSubscribes) {
		this.financeProductSubscribes = financeProductSubscribes;
	}

	public FinanceProductSubscribe addFinanceProductSubscribe(FinanceProductSubscribe financeProductSubscribe) {
		getFinanceProductSubscribes().add(financeProductSubscribe);
		financeProductSubscribe.setMember(this);

		return financeProductSubscribe;
	}

	public FinanceProductSubscribe removeFinanceProductSubscribe(FinanceProductSubscribe financeProductSubscribe) {
		getFinanceProductSubscribes().remove(financeProductSubscribe);
		financeProductSubscribe.setMember(null);

		return financeProductSubscribe;
	}


	//bi-directional many-to-one association to FinancialPlanner
	@OneToMany(mappedBy="member")
	public Set<FinancialPlanner> getFinancialPlanners() {
		return this.financialPlanners;
	}

	public void setFinancialPlanners(Set<FinancialPlanner> financialPlanners) {
		this.financialPlanners = financialPlanners;
	}

	public FinancialPlanner addFinancialPlanner(FinancialPlanner financialPlanner) {
		getFinancialPlanners().add(financialPlanner);
		financialPlanner.setMember(this);

		return financialPlanner;
	}

	public FinancialPlanner removeFinancialPlanner(FinancialPlanner financialPlanner) {
		getFinancialPlanners().remove(financialPlanner);
		financialPlanner.setMember(null);

		return financialPlanner;
	}


	//bi-directional many-to-one association to MemberAccount
	@OneToMany(mappedBy="member")
	public Set<MemberAccount> getMemberAccounts() {
		return this.memberAccounts;
	}

	public void setMemberAccounts(Set<MemberAccount> memberAccounts) {
		this.memberAccounts = memberAccounts;
	}

	public MemberAccount addMemberAccount(MemberAccount memberAccount) {
		getMemberAccounts().add(memberAccount);
		memberAccount.setMember(this);

		return memberAccount;
	}

	public MemberAccount removeMemberAccount(MemberAccount memberAccount) {
		getMemberAccounts().remove(memberAccount);
		memberAccount.setMember(null);

		return memberAccount;
	}


	//bi-directional many-to-one association to MemberBankcard
	@OneToMany(mappedBy="member")
	public Set<MemberBankcard> getMemberBankcards() {
		return this.memberBankcards;
	}

	public void setMemberBankcards(Set<MemberBankcard> memberBankcards) {
		this.memberBankcards = memberBankcards;
	}

	public MemberBankcard addMemberBankcard(MemberBankcard memberBankcard) {
		getMemberBankcards().add(memberBankcard);
		memberBankcard.setMember(this);

		return memberBankcard;
	}

	public MemberBankcard removeMemberBankcard(MemberBankcard memberBankcard) {
		getMemberBankcards().remove(memberBankcard);
		memberBankcard.setMember(null);

		return memberBankcard;
	}


	//bi-directional many-to-one association to MemberDepositRecord
	@OneToMany(mappedBy="member")
	public Set<MemberDepositRecord> getMemberDepositRecords() {
		return this.memberDepositRecords;
	}

	public void setMemberDepositRecords(Set<MemberDepositRecord> memberDepositRecords) {
		this.memberDepositRecords = memberDepositRecords;
	}

	public MemberDepositRecord addMemberDepositRecord(MemberDepositRecord memberDepositRecord) {
		getMemberDepositRecords().add(memberDepositRecord);
		memberDepositRecord.setMember(this);

		return memberDepositRecord;
	}

	public MemberDepositRecord removeMemberDepositRecord(MemberDepositRecord memberDepositRecord) {
		getMemberDepositRecords().remove(memberDepositRecord);
		memberDepositRecord.setMember(null);

		return memberDepositRecord;
	}


	//bi-directional many-to-one association to MemberProfitRecord
	@OneToMany(mappedBy="member")
	public Set<MemberProfitRecord> getMemberProfitRecords() {
		return this.memberProfitRecords;
	}

	public void setMemberProfitRecords(Set<MemberProfitRecord> memberProfitRecords) {
		this.memberProfitRecords = memberProfitRecords;
	}

	public MemberProfitRecord addMemberProfitRecord(MemberProfitRecord memberProfitRecord) {
		getMemberProfitRecords().add(memberProfitRecord);
		memberProfitRecord.setMember(this);

		return memberProfitRecord;
	}

	public MemberProfitRecord removeMemberProfitRecord(MemberProfitRecord memberProfitRecord) {
		getMemberProfitRecords().remove(memberProfitRecord);
		memberProfitRecord.setMember(null);

		return memberProfitRecord;
	}


	//bi-directional many-to-one association to MemberPucChargeHome
	@OneToMany(mappedBy="member")
	public Set<MemberPucChargeHome> getMemberPucChargeHomes() {
		return this.memberPucChargeHomes;
	}

	public void setMemberPucChargeHomes(Set<MemberPucChargeHome> memberPucChargeHomes) {
		this.memberPucChargeHomes = memberPucChargeHomes;
	}

	public MemberPucChargeHome addMemberPucChargeHome(MemberPucChargeHome memberPucChargeHome) {
		getMemberPucChargeHomes().add(memberPucChargeHome);
		memberPucChargeHome.setMember(this);

		return memberPucChargeHome;
	}

	public MemberPucChargeHome removeMemberPucChargeHome(MemberPucChargeHome memberPucChargeHome) {
		getMemberPucChargeHomes().remove(memberPucChargeHome);
		memberPucChargeHome.setMember(null);

		return memberPucChargeHome;
	}


	//bi-directional many-to-one association to MemberWithdrawRecord
	@OneToMany(mappedBy="member")
	public Set<MemberWithdrawRecord> getMemberWithdrawRecords() {
		return this.memberWithdrawRecords;
	}

	public void setMemberWithdrawRecords(Set<MemberWithdrawRecord> memberWithdrawRecords) {
		this.memberWithdrawRecords = memberWithdrawRecords;
	}

	public MemberWithdrawRecord addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord) {
		getMemberWithdrawRecords().add(memberWithdrawRecord);
		memberWithdrawRecord.setMember(this);

		return memberWithdrawRecord;
	}

	public MemberWithdrawRecord removeMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord) {
		getMemberWithdrawRecords().remove(memberWithdrawRecord);
		memberWithdrawRecord.setMember(null);

		return memberWithdrawRecord;
	}


	//bi-directional many-to-one association to OverseaConfigSubscribe
	@OneToMany(mappedBy="member")
	public Set<OverseaConfigSubscribe> getOverseaConfigSubscribes() {
		return this.overseaConfigSubscribes;
	}

	public void setOverseaConfigSubscribes(Set<OverseaConfigSubscribe> overseaConfigSubscribes) {
		this.overseaConfigSubscribes = overseaConfigSubscribes;
	}

	public OverseaConfigSubscribe addOverseaConfigSubscribe(OverseaConfigSubscribe overseaConfigSubscribe) {
		getOverseaConfigSubscribes().add(overseaConfigSubscribe);
		overseaConfigSubscribe.setMember(this);

		return overseaConfigSubscribe;
	}

	public OverseaConfigSubscribe removeOverseaConfigSubscribe(OverseaConfigSubscribe overseaConfigSubscribe) {
		getOverseaConfigSubscribes().remove(overseaConfigSubscribe);
		overseaConfigSubscribe.setMember(null);

		return overseaConfigSubscribe;
	}


	//bi-directional many-to-one association to SubjectBbinPurchaseRecord
	@OneToMany(mappedBy="member")
	public Set<SubjectBbinPurchaseRecord> getSubjectBbinPurchaseRecords() {
		return this.subjectBbinPurchaseRecords;
	}

	public void setSubjectBbinPurchaseRecords(Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords) {
		this.subjectBbinPurchaseRecords = subjectBbinPurchaseRecords;
	}

	public SubjectBbinPurchaseRecord addSubjectBbinPurchaseRecord(SubjectBbinPurchaseRecord subjectBbinPurchaseRecord) {
		getSubjectBbinPurchaseRecords().add(subjectBbinPurchaseRecord);
		subjectBbinPurchaseRecord.setMember(this);

		return subjectBbinPurchaseRecord;
	}

	public SubjectBbinPurchaseRecord removeSubjectBbinPurchaseRecord(SubjectBbinPurchaseRecord subjectBbinPurchaseRecord) {
		getSubjectBbinPurchaseRecords().remove(subjectBbinPurchaseRecord);
		subjectBbinPurchaseRecord.setMember(null);

		return subjectBbinPurchaseRecord;
	}


	//bi-directional many-to-one association to SubjectOrderRecord
	@OneToMany(mappedBy="member")
	public Set<SubjectOrderRecord> getSubjectOrderRecords() {
		return this.subjectOrderRecords;
	}

	public void setSubjectOrderRecords(Set<SubjectOrderRecord> subjectOrderRecords) {
		this.subjectOrderRecords = subjectOrderRecords;
	}

	public SubjectOrderRecord addSubjectOrderRecord(SubjectOrderRecord subjectOrderRecord) {
		getSubjectOrderRecords().add(subjectOrderRecord);
		subjectOrderRecord.setMember(this);

		return subjectOrderRecord;
	}

	public SubjectOrderRecord removeSubjectOrderRecord(SubjectOrderRecord subjectOrderRecord) {
		getSubjectOrderRecords().remove(subjectOrderRecord);
		subjectOrderRecord.setMember(null);

		return subjectOrderRecord;
	}


	//bi-directional many-to-one association to SubjectPurchaseRecord
	@OneToMany(mappedBy="member")
	public Set<SubjectPurchaseRecord> getSubjectPurchaseRecords() {
		return this.subjectPurchaseRecords;
	}

	public void setSubjectPurchaseRecords(Set<SubjectPurchaseRecord> subjectPurchaseRecords) {
		this.subjectPurchaseRecords = subjectPurchaseRecords;
	}

	public SubjectPurchaseRecord addSubjectPurchaseRecord(SubjectPurchaseRecord subjectPurchaseRecord) {
		getSubjectPurchaseRecords().add(subjectPurchaseRecord);
		subjectPurchaseRecord.setMember(this);

		return subjectPurchaseRecord;
	}

	public SubjectPurchaseRecord removeSubjectPurchaseRecord(SubjectPurchaseRecord subjectPurchaseRecord) {
		getSubjectPurchaseRecords().remove(subjectPurchaseRecord);
		subjectPurchaseRecord.setMember(null);

		return subjectPurchaseRecord;
	}

}