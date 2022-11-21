package acme.features.authenticated.teacher.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.features.authenticated.teacher.AuthenticatedTeacherRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Teacher;

@Service
public class TeacherCourseUpdateService implements AbstractUpdateService<Teacher, Course>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected TeacherCourseRepository repository;
	
	@Autowired
	protected AuthenticatedTeacherRepository teacherRepository;
	
	@Override
	public boolean authorise(final Request<Course> request) {
		assert request != null;
		
		Integer idLogin = request.getPrincipal().getActiveRoleId();
		int idCourse = request.getModel().getInteger("id");
		Course t = this.repository.findCourseById(idCourse);
		Integer idOwner = t.getTeacher().getId();
		
		boolean isPublished = t.isPublished();
		
		return idLogin.equals(idOwner) && !isPublished;
	}
	
	@Override
	public Course findOne(final Request<Course> request) {
		assert request != null;

		Course result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findCourseById(id);

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
	public void validate(final Request<Course> request, final Course entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	    
	    boolean soLongAbstractMessage = entity.getAbstractMessage().length()>256;
	    errors.state(request, !soLongAbstractMessage, "abstractMessage", "any.Course.error.soLongAbstractMessage");
		
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
	public void update(final Request<Course> request, final Course entity) {
		assert request != null;
		assert entity != null;
		
		boolean isPublished = request.getModel().getBoolean("isPublished");
		if(isPublished) {
			entity.setPublished(true);
		}

		this.repository.save(entity);
		
	}
}