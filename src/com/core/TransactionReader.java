package com.core;

import java.io.IOException;
import java.util.List;

import com.models.BillingTransactionDetails;

public interface TransactionReader {

	public void readFromFile() throws IOException;
	
	public void populateTransctionDetails(String line);
	
	public List<BillingTransactionDetails> getTransDetails();
}
