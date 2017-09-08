package com.item.finance.bean;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
	private Set<AssociatedAccount> associatedAccounts = new HashSet<>();
	private Set<BbinInfo> bbinInfos = new HashSet<>();
	private Set<Feedback> feedbacks = new HashSet<>();
	private Set<FinanceProductSubscribe> financeProductSubscribes = new HashSet<>();
	private Set<FinanceProductSubscribeRecord> financeProductSubscribeRecords = new HashSet<>();
	private Set<FinancialPlanner> financialPlanners = new HashSet<>();
	private Set<MemberAccount> memberAccounts = new HashSet<>();
	private Set<MemberBankcard> memberBankcards = new HashSet<>();
	private Set<MemberDepositRecord> memberDepositRecords = new HashSet<>();
	private Set<MemberProfitRecord> memberProfitRecords = new HashSet<>();
	private Set<MemberPucChargeHome> memberPucChargeHomes = new HashSet<>();
	private Set<MemberPucChargeItem> memberPucChargeItems = new HashSet<>();
	private Set<MemberTally> memberTallies = new HashSet<>();
	private Set<MemberTradeRecord> memberTradeRecords = new HashSet<>();
	private Set<MemberWithdrawRecord> memberWithdrawRecords = new HashSet<>();
	private Set<OverseaConfigSubscribe> overseaConfigSubscribes = new HashSet<>();
	private Set<SubjectBbinPurchaseRecord> subjectBbinPurchaseRecords = new HashSet<>();
	private Set<SubjectOrderRecord> subjectOrderRecords = new HashSet<>();

	public Member() {
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


	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="member")
	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setMember(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setMember(null);

		return feedback;
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


	//bi-directional many-to-one association to FinanceProductSubscribeRecord
	@OneToMany(mappedBy="member")
	public Set<FinanceProductSubscribeRecord> getFinanceProductSubscribeRecords() {
		return this.financeProductSubscribeRecords;
	}

	public void setFinanceProductSubscribeRecords(Set<FinanceProductSubscribeRecord> financeProductSubscribeRecords) {
		this.financeProductSubscribeRecords = financeProductSubscribeRecords;
	}

	public FinanceProductSubscribeRecord addFinanceProductSubscribeRecord(FinanceProductSubscribeRecord financeProductSubscribeRecord) {
		getFinanceProductSubscribeRecords().add(financeProductSubscribeRecord);
		financeProductSubscribeRecord.setMember(this);

		return financeProductSubscribeRecord;
	}

	public FinanceProductSubscribeRecord removeFinanceProductSubscribeRecord(FinanceProductSubscribeRecord financeProductSubscribeRecord) {
		getFinanceProductSubscribeRecords().remove(financeProductSubscribeRecord);
		financeProductSubscribeRecord.setMember(null);

		return financeProductSubscribeRecord;
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


	//bi-directional many-to-one association to MemberPucChargeItem
	@OneToMany(mappedBy="member")
	public Set<MemberPucChargeItem> getMemberPucChargeItems() {
		return this.memberPucChargeItems;
	}

	public void setMemberPucChargeItems(Set<MemberPucChargeItem> memberPucChargeItems) {
		this.memberPucChargeItems = memberPucChargeItems;
	}

	public MemberPucChargeItem addMemberPucChargeItem(MemberPucChargeItem memberPucChargeItem) {
		getMemberPucChargeItems().add(memberPucChargeItem);
		memberPucChargeItem.setMember(this);

		return memberPucChargeItem;
	}

	public MemberPucChargeItem removeMemberPucChargeItem(MemberPucChargeItem memberPucChargeItem) {
		getMemberPucChargeItems().remove(memberPucChargeItem);
		memberPucChargeItem.setMember(null);

		return memberPucChargeItem;
	}


	//bi-directional many-to-one association to MemberTally
	@OneToMany(mappedBy="member")
	public Set<MemberTally> getMemberTallies() {
		return this.memberTallies;
	}

	public void setMemberTallies(Set<MemberTally> memberTallies) {
		this.memberTallies = memberTallies;
	}

	public MemberTally addMemberTally(MemberTally memberTally) {
		getMemberTallies().add(memberTally);
		memberTally.setMember(this);

		return memberTally;
	}

	public MemberTally removeMemberTally(MemberTally memberTally) {
		getMemberTallies().remove(memberTally);
		memberTally.setMember(null);

		return memberTally;
	}


	//bi-directional many-to-one association to MemberTradeRecord
	@OneToMany(mappedBy="member")
	public Set<MemberTradeRecord> getMemberTradeRecords() {
		return this.memberTradeRecords;
	}

	public void setMemberTradeRecords(Set<MemberTradeRecord> memberTradeRecords) {
		this.memberTradeRecords = memberTradeRecords;
	}

	public MemberTradeRecord addMemberTradeRecord(MemberTradeRecord memberTradeRecord) {
		getMemberTradeRecords().add(memberTradeRecord);
		memberTradeRecord.setMember(this);

		return memberTradeRecord;
	}

	public MemberTradeRecord removeMemberTradeRecord(MemberTradeRecord memberTradeRecord) {
		getMemberTradeRecords().remove(memberTradeRecord);
		memberTradeRecord.setMember(null);

		return memberTradeRecord;
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


	//bi-directional many-to-one association to SubjectOrderRecord
	@OneToMany(mappedBy="member")
	public Set<SubjectOrderRecord> getSubjectOrderRecords() {
		return this.subjectOrderRecords;
	}

	public void setSubjectOrderRecords(Set<SubjectOrderRecord> subjectOrderRecords) {
		this.subjectOrderRecords = subjectOrderRecords;
	}

}