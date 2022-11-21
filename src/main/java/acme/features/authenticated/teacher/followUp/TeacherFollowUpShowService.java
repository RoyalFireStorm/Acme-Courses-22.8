package acme.features.authenticated.teacher.followUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.followUp.FollowUp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Teacher;

@Service
public class TeacherFollowUpShowService implements AbstractShowService<Teacher, FollowUp>{

	@Autowired
	TeacherFollowUpRepository repository;
	
	@Override
	public boolean authorise(final Request<FollowUp> request) {
		assert request != null;

		Integer idLogin = request.getPrincipal().getActiveRoleId();
		int idTutorial = request.getModel().getInteger("id");
		FollowUp t = this.repository.findFollowUpById(idTutorial);
		Integer idOwner = t.getHelpRequest().getTeacher().getId();
		
		
		return idLogin.equals(idOwner);
	}

	@Override
	public void unbind(final Request<FollowUp> request, final FollowUp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "sequenceNumber","moment", "message", "link");
	}

	@Override
	public FollowUp findOne(final Request<FollowUp> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		
		return this.repository.findFollowUpById(id);
	}

}
