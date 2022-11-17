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

package acme.features.any.blink;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.blink.Blink;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyBlinkRepository extends AbstractRepository {

	@Query(value = "select b from Blink b where month(b.moment) >= month(?1) and year(b.moment) >= year(?1) order by b.moment asc")
	Collection<Blink> findLessThanAMonth(LocalDate time);
	
}
