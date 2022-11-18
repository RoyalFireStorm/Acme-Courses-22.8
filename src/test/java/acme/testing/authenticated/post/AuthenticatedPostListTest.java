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


public class AuthenticatedPostListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/authenticated/post/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AuthenticatedPostListPositiveTest (final int recordIndex, final String moment, final String caption, final String message, final String informational, final String link) {
		super.navigateHome();
		super.signIn("learner01", "learner01");
		super.clickOnMenu("Posts");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, caption);
		super.checkColumnHasValue(recordIndex, 2, message);
		super.checkColumnHasValue(recordIndex, 3, informational);
		super.checkColumnHasValue(recordIndex, 4, link);
		
		super.signOut();
		
	}
	
	@Test
	@Order(11)
	public void AuthenticatedPostListNegativeTest () {
		super.navigateHome();
		
		super.navigate("/authenticated/post/list");
		
		super.checkErrorsExist();
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
