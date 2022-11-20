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

package acme.testing.teacher.course;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class TeacherCourseShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/teacher/course/showpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void TeacherCourseShowPositiveTest (final String account, final int recordIndex, final String caption, final String ticker, final String abstractMessage, final String link) {
		super.navigateHome();
		super.signIn(account, account);
		super.clickOnMenu("Teacher","My Courses");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("caption", caption);
		super.checkInputBoxHasValue("ticker", ticker);
		super.checkInputBoxHasValue("abstractMessage", abstractMessage);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
		

	}
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
