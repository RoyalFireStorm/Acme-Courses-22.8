/*
 * Dashboard.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.forms;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Integer totalNumberTheoryTutorials;
	Integer totalNumberLabTutorials;
	Integer totalNumberOfProposedHelpRequests;
	Integer totalNumberOfAcceptedHelpRequests;
	Integer totalNumberOfDeniedHelpRequests;
	
	Map<String, Double> averageCostByCurrencyTheoryTutorials;
	Map<String, Double> deviationCostByCurrencyTheoryTutorials;
	Map<String, Double> minCostByCurrencyTheoryTutorials;
	Map<String, Double> maxCostByCurrencyTheoryTutorials;
	
	Map<String, Double> averageCostByCurrencyLabTutorials;
	Map<String, Double> deviationCostByCurrencyLabTutorials;
	Map<String, Double> minCostByCurrencyLabTutorials;
	Map<String, Double> maxCostByCurrencyLabTutorials;

	Map<String,Double> averageBudgetByStatusHelpRequests;
	Map<String,Double> deviationBudgetByStatusHelpRequests;
	Map<String,Double> minBudgetByStatusHelpRequests;
	Map<String,Double> maxBudgetByStatusHelpRequests;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
