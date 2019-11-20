package com.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.constants.PaymentTypes;

public class BillingTransactionDetails {

	private String transactionId;
	private LocalDateTime transactionDate;
	private BigDecimal amount;
	private String merchantName;
	private PaymentTypes paymentType;
	private String reversalTransactionId;

	public BillingTransactionDetails(String transactionId, LocalDateTime transactionDate, BigDecimal amount,
			String merchantName, PaymentTypes paymentType) {

		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.merchantName = merchantName;
		this.paymentType = paymentType;
	}

	public BillingTransactionDetails(String transactionId, LocalDateTime transactionDate, BigDecimal amount,
			String merchantName, PaymentTypes paymentType, String reversalTransactionId) {

		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.merchantName = merchantName;
		this.paymentType = paymentType;
		this.reversalTransactionId = reversalTransactionId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public PaymentTypes getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentTypes paymentType) {
		this.paymentType = paymentType;
	}

	public String getReversalTransactionId() {
		return reversalTransactionId;
	}

	public void setReversalTransactionId(String reversalTransactionId) {
		this.reversalTransactionId = reversalTransactionId;
	}

}
