package acme.features.authenticated.teacher.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tutorial.Tutorial;
import acme.entities.tutorial.TutorialType;
import acme.features.authenticated.teacher.AuthenticatedTeacherRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Teacher;

@Service
public class TeacherTheoryTutorialCreateService implements AbstractCreateService<Teacher, Tutorial>{

	@Autowired
	protected TeacherTutorialRepository repository;
	
	@Autowired
	protected AuthenticatedTeacherRepository teacherRepository;

	// AbstractCreateService<Authenticated, Tutorial> interface ---------------


	@Override
	public boolean authorise(final Request<Tutorial> request) {
		assert request != null;

		boolean result;

		result = request.getPrincipal().hasRole(Teacher.class);

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
	public void unbind(final Request<Tutorial> request, final Tutorial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title","ticker", "abstractMessage","cost", "link", "type", "isPublished");
	}

	@Override
	public Tutorial instantiate(final Request<Tutorial> request) {
		assert request != null;

		Tutorial result= new Tutorial();;
		int id = request.getPrincipal().getAccountId();
		Teacher t = this.teacherRepository.findOneTeacherByUserAccountId(id);
		
		result.setTeacher(t);
		result.setPublished(false);
		result.setType(TutorialType.THEORY);

		return result;
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
	public void create(final Request<Tutorial> request, final Tutorial entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
}
