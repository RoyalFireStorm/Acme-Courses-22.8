package acme.features.teacher.helpRequest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.helpRequest.HelpRequest;
import acme.framework.controllers.AbstractController;
import acme.roles.Teacher;

@Controller
public class TeacherHelpRequestController extends AbstractController<Teacher, HelpRequest>{

	@Autowired
	private TeacherHelpRequestListService listService;
	
	@Autowired
	private TeacherHelpRequestShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
