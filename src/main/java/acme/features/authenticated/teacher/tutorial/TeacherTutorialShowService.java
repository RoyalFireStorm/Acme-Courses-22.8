package acme.features.authenticated.teacher.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tutorial.Tutorial;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Teacher;

@Service
public class TeacherTutorialShowService implements AbstractShowService<Teacher, Tutorial>{

	@Autowired
	TeacherTutorialRepository repository;
	
	@Override
	public boolean authorise(final Request<Tutorial> request) {
		assert request != null;
		
		Integer idLogin = request.getPrincipal().getActiveRoleId();
		int idTutorial = request.getModel().getInteger("id");
		Tutorial t = this.repository.findTutorialById(idTutorial);
		Integer idOwner = t.getTeacher().getId();
		
		
		return idLogin.equals(idOwner);
	}

	@Override
	public void unbind(final Request<Tutorial> request, final Tutorial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title","ticker", "abstractMessage","cost", "link", "type", "isPublished");
		model.setAttribute("isPublished", entity.isPublished());
	}

	@Override
	public Tutorial findOne(final Request<Tutorial> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		
		return this.repository.findTutorialById(id);
	}

}
