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

package acme.features.authenticated.post;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.post.Post;
import acme.entities.tutorial.Tutorial;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedPostRepository extends AbstractRepository {

	@Query(value = "select p from Post p where month(p.moment) >= month(?1) and year(p.moment) >= year(?1) order by p.moment asc")
	Collection<Post> findLessThanAMonth(LocalDate time);
	
	@Query("select p from Post p where p.id= :id")
	Post findPostById(int id);
	
}
