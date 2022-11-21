/*
 * AuthenticatedBlinkCreateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.blink;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.blink.Blink;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.HttpMethod;
import acme.framework.controllers.Request;
import acme.framework.controllers.Response;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.roles.Any;
import acme.framework.services.AbstractCreateService;

@Service
public class AnyBlinkCreateService implements AbstractCreateService<Any, Blink> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyBlinkRepository repository;

	// AbstractCreateService<Authenticated, Blink> interface ---------------


	@Override
	public boolean authorise(final Request<Blink> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Blink> request, final Blink entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "caption", "author", "message","email");
		
	}

	@Override
	public void unbind(final Request<Blink> request, final Blink entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "caption", "author", "message","email");
		model.setAttribute("confirmation", false);
	}

	@Override
	public Blink instantiate(final Request<Blink> request) {
		assert request != null;

		Blink result= new Blink();;
		Date moment = new Date();
		
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<Blink> request, final Blink entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation = request.getModel().getBoolean("confirmation");
	    errors.state(request, confirmation, "confirmation", "any.blink.error.confirmation");
	    
	    boolean soShortCaption = entity.getCaption().length()<3;
	    errors.state(request, !soShortCaption, "caption", "any.blink.error.soShortCaption");
	    
	    boolean soShortMessage = entity.getMessage().length()<3;
	    errors.state(request, !soShortMessage, "message", "any.blink.error.soShortMessage");
	}

	@Override
	public void create(final Request<Blink> request, final Blink entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}


}
