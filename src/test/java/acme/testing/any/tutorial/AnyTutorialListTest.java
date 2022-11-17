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

package acme.testing.any.tutorial;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyTutorialListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/tutorial/lablistpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyLabTutorialListPositiveTest (final int recordIndex, final String title, final String ticker, final String abstractMessage, final String cost, final String link) {
		super.navigateHome();
		super.clickOnMenu("Tutorials","Lab Tutorials");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, ticker);
		super.checkColumnHasValue(recordIndex, 2, abstractMessage);
		super.checkColumnHasValue(recordIndex, 3, cost);
		super.checkColumnHasValue(recordIndex, 4, link);
		

	}
	
	@ParameterizedTest
	@CsvFileSource(resources="/any/tutorial/theorylistpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyTheoryTutorialListPositiveTest (final int recordIndex, final String title, final String ticker, final String abstractMessage, final String cost, final String link) {
		super.navigateHome();
		super.clickOnMenu("Tutorials","Theory Tutorials");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, ticker);
		super.checkColumnHasValue(recordIndex, 2, abstractMessage);
		super.checkColumnHasValue(recordIndex, 3, cost);
		super.checkColumnHasValue(recordIndex, 4, link);
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
