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

package acme.testing.learner.followUp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class LearnerFollowUpListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/learner/followUp/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void LearnerFollowUpListPositiveTest (final String account, final int recordIndex, final int recordIndex2, final String sequenceNumber, final String moment,
			final String message, final String link) {
		
		super.navigateHome();
		super.signIn(account, account);
		super.clickOnMenu("Learner","My Help Requests");	
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnButton("Follow Ups");
		super.checkListingExists();
		super.sortListing(0, "asc");		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex2, 0, sequenceNumber);
		super.checkColumnHasValue(recordIndex2, 1, moment);
		super.checkColumnHasValue(recordIndex2, 2, message);
		super.checkColumnHasValue(recordIndex2, 3, link);
		
		super.signOut();
		

	}
	
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
