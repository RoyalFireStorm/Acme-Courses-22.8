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


public class AnyTutorialShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/tutorial/labshowpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyLabTutorialShowPositiveTest (final int recordIndex, final String title, final String ticker, final String abstractMessage, final String cost, final String link, final String type) {
		super.navigateHome();
		super.clickOnMenu("Our Products","Lab Tutorials");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("ticker", ticker);
		super.checkInputBoxHasValue("abstractMessage", abstractMessage);
		super.checkInputBoxHasValue("cost", cost);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("type", type);
		
		super.navigateHome();
		

	}
	
	@ParameterizedTest
	@CsvFileSource(resources="/any/tutorial/theoryshowpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyTheoryTutorialShowPositiveTest (final int recordIndex, final String title, final String ticker, final String abstractMessage, final String cost, final String link, final String type) {
		super.navigateHome();
		super.clickOnMenu("Our Products","Theory Tutorials");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("ticker", ticker);
		super.checkInputBoxHasValue("abstractMessage", abstractMessage);
		super.checkInputBoxHasValue("cost", cost);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("type", type);
		
		super.navigateHome();
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
