package acme.features.teacher.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Teacher;

@Service
public class TeacherCourseShowService implements AbstractShowService<Teacher, Course>{

	@Autowired
	TeacherCourseRepository repository;
	
	@Override
	public boolean authorise(final Request<Course> request) {
		assert request != null;

		Integer idLogin = request.getPrincipal().getActiveRoleId();
		int idTutorial = request.getModel().getInteger("id");
		Course t = this.repository.findCourseById(idTutorial);
		Integer idOwner = t.getTeacher().getId();
		
		
		return idLogin.equals(idOwner);
	}

	@Override
	public void unbind(final Request<Course> request, final Course entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "caption","ticker", "abstractMessage", "link");
	}

	@Override
	public Course findOne(final Request<Course> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		
		return this.repository.findCourseById(id);
	}

}
