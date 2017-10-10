package com.item.finance.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sys_recharge_price_config database table.
 * 
 */
@Entity
@Table(name="sys_recharge_price_config")
@NamedQuery(name="SysRechargePriceConfig.findAll", query="SELECT s FROM SysRechargePriceConfig s")
public class SysRechargePriceConfig  {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date createDate;
	private BigDecimal marketPrice;
	private BigDecimal sellPrice;
	private String type;
	private Date updateDate;

	public SysRechargePriceConfig() {
	}


	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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


	@Column(name="market_price", nullable=false, precision=10, scale=2)
	public BigDecimal getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}


	@Column(name="sell_price", nullable=false, precision=10, scale=2)
	public BigDecimal getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}


	@Column(nullable=false, length=32)
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

}