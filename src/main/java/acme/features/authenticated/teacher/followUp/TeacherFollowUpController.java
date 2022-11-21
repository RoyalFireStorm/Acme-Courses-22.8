package acme.features.authenticated.teacher.followUp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.followUp.FollowUp;
import acme.framework.controllers.AbstractController;
import acme.roles.Teacher;

@Controller
public class TeacherFollowUpController extends AbstractController<Teacher, FollowUp>{

	@Autowired
	private TeacherFollowUpListService listService;
	
	@Autowired
	private TeacherFollowUpShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
