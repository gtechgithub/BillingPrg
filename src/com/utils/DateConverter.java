package com.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.constants.Constants;
import com.exception.BillingException;

public interface DateConverter {

	public static LocalDateTime convertStringToDate(String dateString) {
		// convert string to date time
		LocalDateTime dateTime = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.ddmmyyydateFormat);
			dateTime = LocalDateTime.parse(dateString, formatter);

		} catch (DateTimeParseException ex) {
			throw new BillingException("enter the proper date in dd/mm/yyyy hh:mm:ss format");
		} catch (BillingException ex) {
			throw new BillingException("Recevied excepion during date parser " + ex.getMessage());
		}
		return dateTime;

	}}
