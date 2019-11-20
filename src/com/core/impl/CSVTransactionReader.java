package com.core.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.constants.Constants;
import com.constants.PaymentTypes;
import com.core.TransactionReader;
import com.models.BillingTransactionDetails;
import com.utils.DateConverter;

public class CSVTransactionReader implements TransactionReader {

	private List<BillingTransactionDetails> billingTransList;

	public CSVTransactionReader() throws IOException {
		billingTransList = new ArrayList<>();
		readFromFile();
	}

	@Override
	public void readFromFile() throws IOException {
		File file = getFileFromResources("resources//transactiondetails.csv");
		readLines(file);
	}

	@Override
	public void populateTransctionDetails(String line) {
		// BillingTransactionDetails billingTrans = new BillingTransactionDetails ();
		String[] billingTrans = line.split(Constants.DELIM);
		BillingTransactionDetails billingDet = null;

		Stream<String> stringStream = Arrays.stream(billingTrans).map(billingtran -> billingtran.trim());
		billingTrans = stringStream.toArray(size -> new String[size]);

		// check if it is empty or invalid entries
		if (null == billingTrans || billingTrans.length < Constants.NO_OF_FIELDS_PAYMENTS) {
			return;
		}

		// check if it is a header row, checking with few header columns
		if (billingTrans[0].equalsIgnoreCase(Constants.ID) && billingTrans[1].equalsIgnoreCase(Constants.Date)) {
			return;
		}

		billingDet = new BillingTransactionDetails(billingTrans[0], DateConverter.convertStringToDate(billingTrans[1]),
				new BigDecimal(billingTrans[2]), billingTrans[3], PaymentTypes.getByName(billingTrans[4]));

		billingTransList.add(billingDet);

		if (billingTrans.length == Constants.NO_OF_FIELDS_REVERSAL) {
			billingDet.setReversalTransactionId(billingTrans[5]);
		}
	}

	@Override
	public List<BillingTransactionDetails> getTransDetails() {

		return null != billingTransList && billingTransList.size() > 0 ? billingTransList : Collections.emptyList();
	}

	// get file from classpath, resources folder
	private File getFileFromResources(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}
	}

	private void readLines(File file) throws IOException {
		if (file == null)
			return;
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				populateTransctionDetails(line);
			}
		}
	}
}
