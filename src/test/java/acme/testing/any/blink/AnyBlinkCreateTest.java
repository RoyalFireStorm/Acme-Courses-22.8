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

package acme.testing.any.blink;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyBlinkCreateTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/blink/createpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyBlinkCreatePositiveTest (final int recordIndex, final String caption, final String author, final String message, final String email,final String confirmation) {
		super.navigateHome();
		super.clickOnMenu("Anonymous","List Blinks");		
		super.checkListingExists();
		
		super.clickOnButton("Create New Blink");
		
		//Check Listing Work Properly
		super.fillInputBoxIn("caption",caption);
		super.fillInputBoxIn("author",author);
		super.fillInputBoxIn("message",message);
		super.fillInputBoxIn("email",email);
		
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 1, caption);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, message);
		super.checkColumnHasValue(recordIndex, 4, email);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="/any/blink/createnegative.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(20)
	public void AnyBlinkCreateNegativeTest (final int recordIndex, final String caption, final String author, final String message, final String email,final String confirmation) {
		super.navigateHome();
		super.clickOnMenu("Anonymous","List Blinks");		
		super.checkListingExists();
		
		super.clickOnButton("Create New Blink");
		
		//Check Listing Work Properly
		super.fillInputBoxIn("caption",caption);
		super.fillInputBoxIn("author",author);
		super.fillInputBoxIn("message",message);
		super.fillInputBoxIn("email",email);
		
		super.fillInputBoxIn("confirmation", confirmation);
		
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
	}
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
