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

package acme.testing.any.course;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyCourseListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/course/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyCourseListPositiveTest (final int recordIndex, final String caption, final String ticker, final String abstractMessage, final String link) {
		super.navigateHome();
		super.clickOnMenu("Our Products","Courses");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, caption);
		super.checkColumnHasValue(recordIndex, 1, ticker);
		super.checkColumnHasValue(recordIndex, 2, abstractMessage);
		super.checkColumnHasValue(recordIndex, 3, link);
		

	}
	
	@ParameterizedTest
	@CsvFileSource(resources="/any/course/tutorialshowpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyTutorialByCourseListPositiveTest (final int recordIndex,final int recordIndexTutorial, final String title, final String ticker, final String abstractMessage, final String cost, final String link, final String type) {
		super.navigateHome();
		super.clickOnMenu("Our Products","Courses");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnButton("Tutorials in the Course");
		super.checkListingExists();
		super.checkColumnHasValue(recordIndexTutorial, 0, title);
		super.checkColumnHasValue(recordIndexTutorial, 1, ticker);
		super.checkColumnHasValue(recordIndexTutorial, 2, abstractMessage);
		super.checkColumnHasValue(recordIndexTutorial, 3, cost);
		super.checkColumnHasValue(recordIndexTutorial, 4, link);
		super.checkColumnHasValue(recordIndexTutorial, 5, type);
		super.navigateHome();
		
	}
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
