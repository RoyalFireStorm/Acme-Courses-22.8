/*
 * AuthenticatedPostCreateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.post;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.post.Post;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorPostCreateService implements AbstractCreateService<Administrator, Post> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorPostRepository repository;

	// AbstractCreateService<Authenticated, Post> interface ---------------


	@Override
	public boolean authorise(final Request<Post> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Post> request, final Post entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors,"caption", "informational","message", "link");
		
	}

	@Override
	public void unbind(final Request<Post> request, final Post entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,"caption", "informational","message", "link");
		model.setAttribute("confirmation", false);
	}

	@Override
	public Post instantiate(final Request<Post> request) {
		assert request != null;

		Post result= new Post();;
		Date moment = new Date();
		
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<Post> request, final Post entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation = request.getModel().getBoolean("confirmation");
	    errors.state(request, confirmation, "confirmation", "any.post.error.confirmation");
	    
	    boolean soShortCaption = entity.getCaption().length()<3;
	    errors.state(request, !soShortCaption, "caption", "any.post.error.soShortCaption");
	    
	    boolean soShortMessage = entity.getMessage().length()<3;
	    errors.state(request, !soShortMessage, "message", "any.post.error.soShortMessage");
	}

	@Override
	public void create(final Request<Post> request, final Post entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}


}
