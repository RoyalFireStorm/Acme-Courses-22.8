/*
 * AdministratorDashboardRepository.java
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

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(hr) from HelpRequest hr where hr.status = acme.entities.helpRequest.Status.PROPOSED")
	Integer numberOfProposedHelpRequests();
	@Query("select count(hr) from HelpRequest hr where hr.status = acme.entities.helpRequest.Status.ACCEPTED")
	Integer numberOfAcceptedHelpRequests();
	@Query("select count(hr) from HelpRequest hr where hr.status = acme.entities.helpRequest.Status.DENIED")
	Integer numberOfDeniedHelpRequests();
	@Query("select count(t) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.THEORY")
	Integer numberTheoryTutorials();
	@Query("select count(t) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.LAB")
	Integer numberLabTutorials();
	
	@Query("select t.cost.currency, avg(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.THEORY group by t.cost.currency")
	List<String> averageCostByCurrencyTheoryTutorial();
	@Query("select t.cost.currency, stddev(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.THEORY group by t.cost.currency")
	List<String> deviationCostByCurrencyTheoryTutorial();
	@Query("select t.cost.currency, min(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.THEORY group by t.cost.currency")
	List<String> minCostByCurrencyTheoryTutorial();
	@Query("select t.cost.currency, max(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.THEORY group by t.cost.currency")
	List<String> maxCostByCurrencyTheoryTutorial();
	
	@Query("select t.cost.currency, avg(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.LAB group by t.cost.currency")
	List<String> averageCostByCurrencyLabTutorial();
	@Query("select t.cost.currency, stddev(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.LAB group by t.cost.currency")
	List<String> deviationCostByCurrencyLabTutorial();
	@Query("select t.cost.currency, min(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.LAB group by t.cost.currency")
	List<String> minCostByCurrencyLabTutorial();
	@Query("select t.cost.currency, max(t.cost.amount) from Tutorial t where t.type = acme.entities.tutorial.TutorialType.LAB group by t.cost.currency")
	List<String> maxCostByCurrencyLabTutorial();
	
	@Query("select hr.status, avg(hr.budget.amount) from HelpRequest hr group by hr.status")
	List<String> averageBudgetByCurrencyHelpRequest();
	@Query("select hr.status, stddev(hr.budget.amount) from HelpRequest hr group by hr.status")
	List<String> deviationBudgetByCurrencyHelpRequest();
	@Query("select hr.status, min(hr.budget.amount) from HelpRequest hr group by hr.status")
	List<String> minBudgetByCurrencyHelpRequest();
	@Query("select hr.status, max(hr.budget.amount) from HelpRequest hr group by hr.status")
	List<String> maxBudgetByCurrencyHelpRequest();	
	

}
