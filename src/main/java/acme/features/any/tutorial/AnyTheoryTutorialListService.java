package acme.features.any.tutorial;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tutorial.Tutorial;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyTheoryTutorialListService implements AbstractListService<Any, Tutorial>{

	@Autowired
	AnyTutorialRepository repository;
	
	@Override
	public boolean authorise(final Request<Tutorial> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Tutorial> request, final Tutorial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model,"title","ticker","abstractMessage","cost", "link","type");
	}

	@Override
	public Collection<Tutorial> findMany(final Request<Tutorial> request) {
		assert request != null;
		
		Collection<Tutorial> result;
		
		result= this.repository.findTheoryTutorials();
				
		return result;
	}

}
