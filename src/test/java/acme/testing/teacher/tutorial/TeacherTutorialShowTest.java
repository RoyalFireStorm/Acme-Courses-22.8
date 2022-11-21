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

package acme.testing.teacher.tutorial;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class TeacherTutorialShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/teacher/tutorial/labshowpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void TeacherLabTutorialShowPositiveTest (final String account, final int recordIndex, final String title, final String ticker, final String abstractMessage, final String cost, final String link, final String type) {
		super.navigateHome();
		super.signIn(account, account);
		super.clickOnMenu("Teacher","My Lab Tutorials");	
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
		
		super.signOut();
		

	}
	
	@ParameterizedTest
	@CsvFileSource(resources="/teacher/tutorial/theoryshowpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void TeacherTheoryTutorialShowPositiveTest (final String account, final int recordIndex, final String title, final String ticker, final String abstractMessage, final String cost, final String link, final String type) {
		super.navigateHome();
		super.signIn(account, account);
		super.clickOnMenu("Teacher","My Theory Tutorials");		
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
		
		super.signOut();
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
