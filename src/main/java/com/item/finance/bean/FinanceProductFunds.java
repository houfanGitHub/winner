package com.item.finance.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the finance_product_funds database table.
 * 
 */
@Entity
@Table(name="finance_product_funds")
@NamedQuery(name="FinanceProductFunds.findAll", query="SELECT f FROM FinanceProductFunds f")
public class FinanceProductFunds  {
	private int id;//id
	private BigDecimal amount;//募集金额
	private String bankAccount;//'银行账户（支行名称|银行账号|户名）
	private int buyerCount;//购买人数
	private String contract;//私募合同
	private String createDate;//添加时间
	private String endDate;//结束时间
	private BigDecimal floorAmount;//起投金额
	private String investPoints;//投资方向
	private String name;//名称
	private int period;//周期
	private String productFactor;//产品要素
	private String productManager;//基金经理详细
	private String productManagerDesc;//产品管理人介绍
	private String productManagerName;//管理人名称
	private String productManagerPic;//管理人图片
	private String productManagerTitle;//管理人头衔
	private String productStrategy;//产品策略
	private String productTopic;//基金专题/关于基金
	private String ratio;//返佣比例
	private BigDecimal soldAmount;//已售金额
	private String startDate;//开始时间
	private String status;//状态(0:未发布，1:募集中，2:已结束
	private int subscribeCount;//预约人数
	private String type;//产品类型
	private String updateDate;//修改时间
	private BigDecimal yearRate;//年化率
	//private Integer counts;
	public FinanceProductFunds() {
	}

	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	/*@Column(precision=10, scale=2)
	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}*/

	@Column(precision=10, scale=2)
	public BigDecimal getAmount() {
		return this.amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(name="bank_account", length=1000)
	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}


	@Column(name="buyer_count", nullable=false)
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


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	@Column(name="floor_amount", precision=10, scale=2)
	public BigDecimal getFloorAmount() {
		return this.floorAmount;
	}

	public void setFloorAmount(BigDecimal floorAmount) {
		this.floorAmount = floorAmount;
	}


	@Column(name="invest_points")//, nullable=false, length=1000
	public String getInvestPoints() {
		return this.investPoints;
	}

	public void setInvestPoints(String investPoints) {
		this.investPoints = investPoints;
	}


	@Column(length=500)
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


	@Column(name="product_manager_desc")//, nullable=false, length=1000
	public String getProductManagerDesc() {
		return this.productManagerDesc;
	}

	public void setProductManagerDesc(String productManagerDesc) {
		this.productManagerDesc = productManagerDesc;
	}


	@Column(name="product_manager_name")//, nullable=false, length=1000
	public String getProductManagerName() {
		return this.productManagerName;
	}

	public void setProductManagerName(String productManagerName) {
		this.productManagerName = productManagerName;
	}


	@Column(name="product_manager_pic")//, nullable=false, length=1000
	public String getProductManagerPic() {
		return this.productManagerPic;
	}

	public void setProductManagerPic(String productManagerPic) {
		this.productManagerPic = productManagerPic;
	}


	@Column(name="product_manager_title")//, nullable=false, length=1000
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


	@Column(length=200)
	public String getRatio() {
		return this.ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}


	@Column(name="sold_amount", precision=10, scale=2)
	public BigDecimal getSoldAmount() {
		return this.soldAmount;
	}

	public void setSoldAmount(BigDecimal soldAmount) {
		this.soldAmount = soldAmount;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="subscribe_count", nullable=false)
	public int getSubscribeCount() {
		return this.subscribeCount;
	}

	public void setSubscribeCount(int subscribeCount) {
		this.subscribeCount = subscribeCount;
	}


	//@Column(nullable=false, length=10)
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="year_rate", precision=10, scale=2)
	public BigDecimal getYearRate() {
		return this.yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}

}
