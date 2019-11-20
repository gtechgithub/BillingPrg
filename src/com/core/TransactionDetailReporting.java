package com.core;

import java.time.LocalDateTime;

public abstract class TransactionDetailReporting {

	protected TransactionReader transactionReader;
	
	public abstract void getCountAndAverage(LocalDateTime startDateTime, LocalDateTime endDateTime, String merchantName);

}
