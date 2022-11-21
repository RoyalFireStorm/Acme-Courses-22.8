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

package acme.features.authenticated.learner.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface LearnerDashboardRepository extends AbstractRepository {

	@Query("select count(hr) from HelpRequest hr where hr.status = acme.entities.helpRequest.Status.PROPOSED")
	Integer numberOfProposedHelpRequests();
	@Query("select count(hr) from HelpRequest hr where hr.status = acme.entities.helpRequest.Status.ACCEPTED")
	Integer numberOfAcceptedHelpRequests();
	@Query("select count(hr) from HelpRequest hr where hr.status = acme.entities.helpRequest.Status.DENIED")
	Integer numberOfDeniedHelpRequests();

	@Query("select avg(hr.budget.amount), hr.budget.currency, hr.status from HelpRequest hr group by hr.budget.currency, hr.status")
	List<String> averageBudgetByCurrencyAndStatus();
	@Query("select stddev(hr.budget.amount), hr.budget.currency, hr.status from HelpRequest hr group by hr.budget.currency, hr.status")
	List<String> deviationBudgetByCurrencyAndStatus();
	@Query("select min(hr.budget.amount), hr.budget.currency, hr.status from HelpRequest hr group by hr.budget.currency, hr.status")
	List<String> minBudgetByCurrencyAndStatus();
	@Query("select max(hr.budget.amount), hr.budget.currency, hr.status from HelpRequest hr group by hr.budget.currency, hr.status")
	List<String> maxBudgetByCurrencyAndStatus();	
	

}
