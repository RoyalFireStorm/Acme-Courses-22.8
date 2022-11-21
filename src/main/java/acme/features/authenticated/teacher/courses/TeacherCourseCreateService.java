package acme.features.authenticated.teacher.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.features.authenticated.teacher.AuthenticatedTeacherRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Teacher;

@Service
public class TeacherCourseCreateService implements AbstractCreateService<Teacher, Course>{

	@Autowired
	protected TeacherCourseRepository repository;
	
	@Autowired
	protected AuthenticatedTeacherRepository teacherRepository;

	// AbstractCreateService<Authenticated, Course> interface ---------------


	@Override
	public boolean authorise(final Request<Course> request) {
		assert request != null;

		boolean result;

		result = request.getPrincipal().hasRole(Teacher.class);

		return result;
	}

	@Override
	public void bind(final Request<Course> request, final Course entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "caption","ticker", "abstractMessage", "link", "isPublished");
		
	}

	@Override
	public void unbind(final Request<Course> request, final Course entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "caption","ticker", "abstractMessage", "link", "isPublished");
		model.setAttribute("isPublished", entity.isPublished());
	}

	@Override
	public Course instantiate(final Request<Course> request) {
		assert request != null;

		Course result= new Course();;
		int id = request.getPrincipal().getAccountId();
		Teacher t = this.teacherRepository.findOneTeacherByUserAccountId(id);
		
		result.setTeacher(t);
		result.setPublished(false);

		return result;
	}

	@Override
	public void validate(final Request<Course> request, final Course entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	    
	    boolean soLongAbstractMessage = entity.getAbstractMessage().length()>256;
	    errors.state(request, !soLongAbstractMessage, "abstractMessage", "any.Course.error.soLongAbstractMessage");
	}

	@Override
	public void create(final Request<Course> request, final Course entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
}
