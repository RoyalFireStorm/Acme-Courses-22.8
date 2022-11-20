/*
 * FavouriteemailTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.teacher.helpRequest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class TeacherHelpRequestListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/teacher/helpRequest/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void TeacherHelpRequestListPositiveTest (final String account, final int recordIndex, final String status, final String ticker, final String statement,
			final String budget, final String startDate, final String finishDate, final String link) {
		
		super.navigateHome();
		super.signIn(account, account);
		super.clickOnMenu("Teacher","Help Requests");	
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, ticker);
		super.checkColumnHasValue(recordIndex, 2, statement);
		super.checkColumnHasValue(recordIndex, 3, budget);
		super.checkColumnHasValue(recordIndex, 4, startDate);
		super.checkColumnHasValue(recordIndex, 5, finishDate);
		super.checkColumnHasValue(recordIndex, 6, link);
		
		super.signOut();
		

	}
	
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
