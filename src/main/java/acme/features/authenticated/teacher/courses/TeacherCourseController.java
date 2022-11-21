package acme.features.authenticated.teacher.courses;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.course.Course;
import acme.framework.controllers.AbstractController;
import acme.roles.Teacher;

@Controller
public class TeacherCourseController extends AbstractController<Teacher, Course>{

	@Autowired
	private TeacherCourseListAllService listAllService;
	
	@Autowired
	private TeacherCourseShowService showService;
	
	@Autowired
	private TeacherCourseCreateService createService;
	
	@Autowired
	private TeacherCourseUpdateService updateCourseService;
	
	@Autowired
	private TeacherCourseDeleteService deleteCourseService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list-all","list", this.listAllService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateCourseService);
		super.addCommand("delete", this.deleteCourseService);
 
	}
	
	
}
