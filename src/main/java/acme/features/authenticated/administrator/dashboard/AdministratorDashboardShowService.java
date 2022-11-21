/*
 * AdministratorDashboardShowService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.administrator.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDashboardRepository repository;

	// AbstractShowService<Administrator, AdministratorDashboard> interface ----------------


	@Override
	public boolean authorise(final Request<AdministratorDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
		assert request != null;

		final AdministratorDashboard result;
		final Integer totalNumberTheoryTutorials;
		final Integer totalNumberLabTutorials;
		final Integer totalNumberOfProposedHelpRequestes;
		final Integer totalNumberOfAcceptedHelpRequestes;
		final Integer totalNumberOfDeniedHelpRequestes;
		final Map<String,Double> averageCostByCurrencyTheoryTutorial;
		final Map<String,Double> deviationCostByCurrencyTheoryTutorial;
		final Map<String,Double> minCostByCurrencyTheoryTutorial;
		final Map<String,Double> maxCostByCurrencyTheoryTutorial;
		final Map<String,Double> averageCostByCurrencyLabTutorial;
		final Map<String,Double> deviationCostByCurrencyLabTutorial;
		final Map<String,Double> minCostByCurrencyLabTutorial;
		final Map<String,Double> maxCostByCurrencyLabTutorial;
		final Map<String,Double> averageBudgetByStatusHelpRequestes;
		final Map<String,Double> deviationBudgetByStatusHelpRequestes;
		final Map<String,Double> minBudgetByStatusHelpRequestes;
		final Map<String,Double> maxBudgetByStatusHelpRequestes;
		
		totalNumberTheoryTutorials = this.repository.numberTheoryTutorials();
		totalNumberLabTutorials = this.repository.numberLabTutorials();
		totalNumberOfProposedHelpRequestes = this.repository.numberOfProposedHelpRequests();
		totalNumberOfAcceptedHelpRequestes = this.repository.numberOfAcceptedHelpRequests();
		totalNumberOfDeniedHelpRequestes = this.repository.numberOfAcceptedHelpRequests();;
		averageCostByCurrencyTheoryTutorial = this.parseQueryStringDouble(this.repository.averageCostByCurrencyTheoryTutorial());
		deviationCostByCurrencyTheoryTutorial = this.parseQueryStringDouble(this.repository.deviationCostByCurrencyTheoryTutorial());
		minCostByCurrencyTheoryTutorial = this.parseQueryStringDouble(this.repository.minCostByCurrencyTheoryTutorial());
		maxCostByCurrencyTheoryTutorial = this.parseQueryStringDouble(this.repository.maxCostByCurrencyTheoryTutorial());
		averageCostByCurrencyLabTutorial = this.parseQueryStringDouble(this.repository.averageCostByCurrencyLabTutorial());
		deviationCostByCurrencyLabTutorial = this.parseQueryStringDouble(this.repository.deviationCostByCurrencyLabTutorial());
		minCostByCurrencyLabTutorial = this.parseQueryStringDouble(this.repository.minCostByCurrencyLabTutorial());
		maxCostByCurrencyLabTutorial = this.parseQueryStringDouble(this.repository.maxCostByCurrencyLabTutorial());
		averageBudgetByStatusHelpRequestes = this.parseQueryStringDouble(this.repository.averageBudgetByCurrencyHelpRequest());
		deviationBudgetByStatusHelpRequestes = this.parseQueryStringDouble(this.repository.deviationBudgetByCurrencyHelpRequest());
		minBudgetByStatusHelpRequestes = this.parseQueryStringDouble(this.repository.minBudgetByCurrencyHelpRequest());
		maxBudgetByStatusHelpRequestes = this.parseQueryStringDouble(this.repository.maxBudgetByCurrencyHelpRequest());
		
		
		
		result = new AdministratorDashboard();
		result.setTotalNumberTheoryTutorials(totalNumberTheoryTutorials);
		result.setTotalNumberLabTutorials(totalNumberLabTutorials);
		result.setTotalNumberOfProposedHelpRequests(totalNumberOfProposedHelpRequestes);
		result.setTotalNumberOfAcceptedHelpRequests(totalNumberOfAcceptedHelpRequestes);
		result.setTotalNumberOfDeniedHelpRequests(totalNumberOfDeniedHelpRequestes);
		result.setAverageCostByCurrencyTheoryTutorials(averageCostByCurrencyTheoryTutorial);
		result.setDeviationCostByCurrencyTheoryTutorials(deviationCostByCurrencyTheoryTutorial);
		result.setMinCostByCurrencyTheoryTutorials(minCostByCurrencyTheoryTutorial);
		result.setMaxCostByCurrencyTheoryTutorials(maxCostByCurrencyTheoryTutorial);
		result.setAverageCostByCurrencyLabTutorials(averageCostByCurrencyLabTutorial);
		result.setDeviationCostByCurrencyLabTutorials(deviationCostByCurrencyLabTutorial);
		result.setMinCostByCurrencyLabTutorials(minCostByCurrencyLabTutorial);
		result.setMaxCostByCurrencyLabTutorials(maxCostByCurrencyLabTutorial);
		result.setAverageBudgetByStatusHelpRequests(averageBudgetByStatusHelpRequestes);
		result.setDeviationBudgetByStatusHelpRequests(deviationBudgetByStatusHelpRequestes);
		result.setMinBudgetByStatusHelpRequests(minBudgetByStatusHelpRequestes);
		result.setMaxBudgetByStatusHelpRequests(maxBudgetByStatusHelpRequestes);

		return result;
	}

	private Map<String, Double> parseQueryStringDouble(final List<String> list){
		final HashMap<String, Double> aux = new HashMap<String, Double>();
		for(int i=0; i<list.size();i++) {
			final String line= list.get(i);
			final String[] split=line.split(",");
			final Double value=Double.parseDouble(split[1]);
			final String key=split[0];
			aux.put(key, value);
		}
		return aux;
	}
	@Override
	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, //
			"totalNumberTheoryTutorials", "totalNumberLabTutorials", // 
			"totalNumberOfProposedHelpRequests", "totalNumberOfAcceptedHelpRequests", //
			"totalNumberOfDeniedHelpRequests", "averageCostByCurrencyTheoryTutorials", // 
			"deviationCostByCurrencyTheoryTutorials", "minCostByCurrencyTheoryTutorials", //
			"maxCostByCurrencyTheoryTutorials", "averageCostByCurrencyLabTutorials", // 
			"deviationCostByCurrencyLabTutorials", "minCostByCurrencyLabTutorials", //
			"maxCostByCurrencyLabTutorials", "averageBudgetByStatusHelpRequests", // 
			"deviationBudgetByStatusHelpRequests", "minBudgetByStatusHelpRequests", //
			"maxBudgetByStatusHelpRequests");
	}

}
