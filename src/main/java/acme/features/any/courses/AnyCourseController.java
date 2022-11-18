package acme.features.any.courses;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.course.Course;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyCourseController extends AbstractController<Any, Course>{

	@Autowired
	private AnyCourseListAllService listAllService;
	
	@Autowired
	private AnyCourseShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list-all","list", this.listAllService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
