package com.financial.common.model;

public class TimeSeriesData {
	
	private String itemId;
	private String tradingDate;
	private String stockCode;
	private double itemValue;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getTradingDate() {
		return tradingDate;
	}
	public void setTradingDate(String tradingDate) {
		this.tradingDate = tradingDate;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public double getItemValue() {
		return itemValue;
	}
	public void setItemValue(double itemValue) {
		this.itemValue = itemValue;
	}
	
}
