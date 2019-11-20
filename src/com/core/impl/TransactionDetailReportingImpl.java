package com.core.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Iterator;

import com.constants.PaymentTypes;
import com.core.TransactionDetailReporting;
import com.core.TransactionReader;
import com.models.BillingTransactionDetails;

public class TransactionDetailReportingImpl extends TransactionDetailReporting {

	// default constructor
	public TransactionDetailReportingImpl() {
	}

	public TransactionDetailReportingImpl(TransactionReader transactionReader) {
		this.transactionReader = transactionReader;
	}

	@Override
	public void getCountAndAverage(LocalDateTime startDateTime, LocalDateTime endDateTime, String merchantName) {
		Iterator<BillingTransactionDetails> billingTransDetailsIter = transactionReader.getTransDetails()
				.listIterator();

		BigDecimal totalSum = new BigDecimal(0);
		int count = 0;

		// iterate the loop
		while (billingTransDetailsIter.hasNext()) {

			BillingTransactionDetails billingTran = (BillingTransactionDetails) billingTransDetailsIter.next();

			if ((billingTran.getTransactionDate().compareTo(startDateTime) >= 0
					&& billingTran.getTransactionDate().compareTo(endDateTime) <= 0)
					&& (billingTran.getMerchantName().equalsIgnoreCase(merchantName))
					&& (billingTran.getPaymentType().equals(PaymentTypes.PAYMENT))) {
				totalSum = totalSum.add(billingTran.getAmount());
				count++;
			}
		}

		if (count > 0) {
			BigDecimal average = totalSum.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);

			System.out.println("Number of transactions = " + count);
			System.out.println("Average Transaction Value  = " + average);
		} else {
			System.out.println("no records to display");
		}
	}

}
