package acme.features.any.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyCourseShowService implements AbstractShowService<Any, Course>{

	@Autowired
	AnyCourseRepository repository;
	
	@Override
	public boolean authorise(final Request<Course> request) {
		assert request != null;
		return true;
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
