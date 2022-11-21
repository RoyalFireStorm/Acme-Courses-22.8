/*
 * AnonymousShoutRepository.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.teacher.followUp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.followUp.FollowUp;
import acme.entities.helpRequest.HelpRequest;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface TeacherFollowUpRepository extends AbstractRepository {

	@Query("select fu from FollowUp fu where helpRequest.teacher.id=:idRole and helpRequest.id=:idHelpRequest")
	Collection<FollowUp> findAllMyFollowUps(int idRole, int idHelpRequest);
	
	
	@Query("select fu from FollowUp fu where fu.id= :id")
	FollowUp findFollowUpById(int id);
	
	@Query("select hr from HelpRequest hr where hr.id= :id")
	HelpRequest findHelpRequestById(int id);
	
}
