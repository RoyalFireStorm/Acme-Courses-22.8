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

package acme.testing.administrator.dashboard;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.testing.TestHarness;


public class AdministratorDashboardShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/administrator/administrator-dashboard/showpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void administratorDashboardShowPositiveTest (final int recordIndex, final String number) {
		
		super.navigateHome();
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator","Dashboard");	
		
		By locatorDuty;
		String stringDuty;
		List<WebElement> elementDuty;
		locatorDuty = By.xpath("//td");
		elementDuty = super.getDriver().locateMany(locatorDuty);
		stringDuty = elementDuty.get(recordIndex).getText();
		
		assert stringDuty.equals(number);
		super.signOut();
		

	}
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
