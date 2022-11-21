package acme.features.authenticated.teacher.courses;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Teacher;

@Service
public class TeacherCourseListAllService implements AbstractListService<Teacher, Course>{
	
	@Autowired
	TeacherCourseRepository repository;
	
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
		
		request.unbind(entity, model,"caption","ticker", "abstractMessage", "link");
	}

	@Override
	public Collection<Course> findMany(final Request<Course> request) {
		assert request != null;
		
		Collection<Course> result;
		int id = request.getPrincipal().getActiveRoleId();
		
		result= this.repository.findAllMyCourses(id);
				
		return result;
	}

}
