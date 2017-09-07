package com.item.finance.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the finance_product_funds database table.
 * 理财类基金产品表
 */
@Entity
@Table(name="finance_product_funds")
@NamedQuery(name="FinanceProductFund.findAll", query="SELECT f FROM FinanceProductFund f")
public class FinanceProductFund  {

	private int id;
	private BigDecimal amount;
	private String bankAccount;
	private int buyerCount;
	private String contract;
	private Date createDate;
	private Date endDate;
	private BigDecimal floorAmount;
	private String investPoints;
	private String name;
	private int period;
	private String productFactor;
	private String productManager;
	private String productManagerDesc;
	private String productManagerName;
	private String productManagerPic;
	private String productManagerTitle;
	private String productStrategy;
	private String productTopic;
	private String ratio;
	private BigDecimal soldAmount;
	private Date startDate;
	private byte status;
	private int subscribeCount;
	private String type;
	private Date updateDate;
	private BigDecimal yearRate;

	public FinanceProductFund() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(name="bank_account")
	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}


	@Column(name="buyer_count")
	public int getBuyerCount() {
		return this.buyerCount;
	}

	public void setBuyerCount(int buyerCount) {
		this.buyerCount = buyerCount;
	}


	@Lob
	public String getContract() {
		return this.contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
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
	@Column(name="end_date")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Column(name="floor_amount")
	public BigDecimal getFloorAmount() {
		return this.floorAmount;
	}

	public void setFloorAmount(BigDecimal floorAmount) {
		this.floorAmount = floorAmount;
	}


	@Column(name="invest_points")
	public String getInvestPoints() {
		return this.investPoints;
	}

	public void setInvestPoints(String investPoints) {
		this.investPoints = investPoints;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getPeriod() {
		return this.period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}


	@Lob
	@Column(name="product_factor")
	public String getProductFactor() {
		return this.productFactor;
	}

	public void setProductFactor(String productFactor) {
		this.productFactor = productFactor;
	}


	@Lob
	@Column(name="product_manager")
	public String getProductManager() {
		return this.productManager;
	}

	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}


	@Column(name="product_manager_desc")
	public String getProductManagerDesc() {
		return this.productManagerDesc;
	}

	public void setProductManagerDesc(String productManagerDesc) {
		this.productManagerDesc = productManagerDesc;
	}


	@Column(name="product_manager_name")
	public String getProductManagerName() {
		return this.productManagerName;
	}

	public void setProductManagerName(String productManagerName) {
		this.productManagerName = productManagerName;
	}


	@Column(name="product_manager_pic")
	public String getProductManagerPic() {
		return this.productManagerPic;
	}

	public void setProductManagerPic(String productManagerPic) {
		this.productManagerPic = productManagerPic;
	}


	@Column(name="product_manager_title")
	public String getProductManagerTitle() {
		return this.productManagerTitle;
	}

	public void setProductManagerTitle(String productManagerTitle) {
		this.productManagerTitle = productManagerTitle;
	}


	@Lob
	@Column(name="product_strategy")
	public String getProductStrategy() {
		return this.productStrategy;
	}

	public void setProductStrategy(String productStrategy) {
		this.productStrategy = productStrategy;
	}


	@Lob
	@Column(name="product_topic")
	public String getProductTopic() {
		return this.productTopic;
	}

	public void setProductTopic(String productTopic) {
		this.productTopic = productTopic;
	}


	public String getRatio() {
		return this.ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}


	@Column(name="sold_amount")
	public BigDecimal getSoldAmount() {
		return this.soldAmount;
	}

	public void setSoldAmount(BigDecimal soldAmount) {
		this.soldAmount = soldAmount;
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


	@Column(name="subscribe_count")
	public int getSubscribeCount() {
		return this.subscribeCount;
	}

	public void setSubscribeCount(int subscribeCount) {
		this.subscribeCount = subscribeCount;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="year_rate")
	public BigDecimal getYearRate() {
		return this.yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}

}