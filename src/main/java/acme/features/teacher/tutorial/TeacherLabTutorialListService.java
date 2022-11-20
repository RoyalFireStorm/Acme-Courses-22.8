package acme.features.teacher.tutorial;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tutorial.Tutorial;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Teacher;

@Service
public class TeacherLabTutorialListService implements AbstractListService<Teacher, Tutorial>{

	@Autowired
	TeacherTutorialRepository repository;
	
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
		
		request.unbind(entity, model, "title","ticker", "abstractMessage","cost", "link", "type");
	}

	@Override
	public Collection<Tutorial> findMany(final Request<Tutorial> request) {
		assert request != null;
		
		Collection<Tutorial> result;
		int id = request.getPrincipal().getActiveRoleId();
		
		result= this.repository.findMyLabTutorials(id);
				
		return result;
	}

}
