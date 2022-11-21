package acme.features.authenticated.teacher.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tutorial.Tutorial;
import acme.features.authenticated.teacher.AuthenticatedTeacherRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Teacher;

@Service
public class TeacherTutorialUpdateService implements AbstractUpdateService<Teacher, Tutorial>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected TeacherTutorialRepository repository;
	
	@Autowired
	protected AuthenticatedTeacherRepository teacherRepository;
	
	@Override
	public boolean authorise(final Request<Tutorial> request) {
		assert request != null;
		
		Integer idLogin = request.getPrincipal().getActiveRoleId();
		int idTutorial = request.getModel().getInteger("id");
		Tutorial t = this.repository.findTutorialById(idTutorial);
		Integer idOwner = t.getTeacher().getId();
		
		boolean isPublished = t.isPublished();
		
		return idLogin.equals(idOwner) && !isPublished;
	}
	
	@Override
	public Tutorial findOne(final Request<Tutorial> request) {
		assert request != null;

		Tutorial result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findTutorialById(id);

		return result;
	}

	@Override
	public void bind(final Request<Tutorial> request, final Tutorial entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title","ticker", "abstractMessage","cost", "link", "type", "isPublished");
		
	}
	
	@Override
	public void validate(final Request<Tutorial> request, final Tutorial entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean negativeMoney = entity.getCost().getAmount()<0;
	    errors.state(request, !negativeMoney, "cost", "any.tutorial.error.negativeMoney");
	    
	    boolean soLongTitle = entity.getTitle().length()>76;
	    errors.state(request, !soLongTitle, "title", "any.tutorial.error.soLongTitle");
	    
	    boolean soLongAbstractMessage = entity.getAbstractMessage().length()>256;
	    errors.state(request, !soLongAbstractMessage, "abstractMessage", "any.tutorial.error.soLongAbstractMessage");
		
	}

	@Override
	public void unbind(final Request<Tutorial> request, final Tutorial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title","ticker", "abstractMessage","cost", "link", "type", "isPublished");
		
	}	

	@Override
	public void update(final Request<Tutorial> request, final Tutorial entity) {
		assert request != null;
		assert entity != null;
		
		boolean isPublished = request.getModel().getBoolean("isPublished");
		if(isPublished) {
			entity.setPublished(true);
		}

		this.repository.save(entity);
		
	}
}