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

package acme.testing.teacher.followUp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class TeacherFollowUpShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/teacher/followUp/showpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void TeacherHelpRequestShowPositiveTest (final String account, final int recordIndex, final int recordIndex2, final String sequenceNumber, final String moment,
		final String message, final String link) {
		
		super.navigateHome();
		super.signIn(account, account);
		super.clickOnMenu("Teacher","Help Requests");	
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnButton("Follow Ups");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex2);
		super.checkFormExists();
		super.checkInputBoxHasValue("sequenceNumber", sequenceNumber);
		super.checkInputBoxHasValue("moment", moment);
		super.checkInputBoxHasValue("message", message);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
		

	}
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
