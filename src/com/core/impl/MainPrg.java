package com.core.impl;

import java.util.Scanner;

import com.core.TransactionDetailReporting;
import com.exception.BillingException;
import com.utils.DateConverter;

public class MainPrg {

	public static void main(String args[]) {

		TransactionDetailReporting reporting =  null;
		String continueLoop;

		try {
			// load records into the list
			reporting = new TransactionDetailReportingImpl(new CSVTransactionReader());
		} catch (Exception ex) {
			System.out.println("could not able to read from file");
			System.exit(1);
		}

		try (Scanner scan = new Scanner(System.in)) {

			do {
				System.out.println("\nfrom Date:");
				String fromDate = scan.nextLine();
				System.out.println("\nTo Date:");
				String toDate = scan.nextLine();
				System.out.println("\nMerchant:");
				String merchant = scan.nextLine();

				reporting.getCountAndAverage(DateConverter.convertStringToDate(fromDate),
						DateConverter.convertStringToDate(toDate), merchant);

				System.out.println("\n \n Continue: press y, otherwise press anykey");
				continueLoop = scan.nextLine();
			} while (continueLoop.equalsIgnoreCase("Y"));

		} catch (BillingException ex) {
			System.out.println(ex.getMessage());

		}

	}
}
