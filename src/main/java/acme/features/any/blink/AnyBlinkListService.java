package acme.features.any.blink;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.blink.Blink;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyBlinkListService implements AbstractListService<Any, Blink>{

	@Autowired
	AnyBlinkRepository repository;
	
	@Override
	public boolean authorise(final Request<Blink> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Blink> request, final Blink entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "moment","caption", "author","message", "email");
	}

	@Override
	public Collection<Blink> findMany(final Request<Blink> request) {
		assert request != null;
		
		Collection<Blink> result;
		final LocalDate time = LocalDate.now().minusMonths(1);
		result = this.repository.findLessThanAMonth(time);
		
		return result;
	}

}
