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

package acme.testing.authenticated.post;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AuthenticatedPostShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/authenticated/post/showpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AuthenticatedPostShowPositiveTest (final int recordIndex, final String moment, final String caption, final String message, final String informational, final String link) {
		super.navigateHome();
		super.signIn("learner01", "learner01");
		super.clickOnMenu("Posts");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("moment", moment);
		super.checkInputBoxHasValue("caption", caption);
		super.checkInputBoxHasValue("message", message);
		super.checkInputBoxHasValue("informational", informational);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
		

	}
	
	@Test
	@Order(11)
	public void AuthenticatedPostListNegativeTest () {
		super.navigateHome();
		
		super.navigate("/authenticated/post/show");
		
		super.checkErrorsExist();
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
