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

package acme.features.any.tutorial;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tutorial.Tutorial;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyTutorialRepository extends AbstractRepository {

	@Query( "select t from Tutorial t where t.type = acme.entities.tutorial.TutorialType.THEORY" )
	Collection<Tutorial> findTheoryTutorials();
	
	@Query( "select t from Tutorial t where t.type = acme.entities.tutorial.TutorialType.LAB" )
	Collection<Tutorial> findLabTutorials();
	
	@Query("select t from Tutorial t where t.id= :id")
	Tutorial findTutorialById(int id);
	
}
