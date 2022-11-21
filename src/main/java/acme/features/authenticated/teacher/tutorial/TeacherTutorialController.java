package acme.features.authenticated.teacher.tutorial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tutorial.Tutorial;
import acme.framework.controllers.AbstractController;
import acme.roles.Teacher;

@Controller
public class TeacherTutorialController extends AbstractController<Teacher, Tutorial>{

	@Autowired
	private TeacherTheoryTutorialListService theorylistService;
	
	@Autowired
	private TeacherLabTutorialListService lablistService;
	
	@Autowired
	private TeacherTutorialShowService showService;
	
	@Autowired
	private TeacherTheoryTutorialCreateService createTheoryService;
	
	@Autowired
	private TeacherLabTutorialCreateService createLabService;
	
	@Autowired
	private TeacherTutorialUpdateService updateTutorialService;
	
	@Autowired
	private TeacherTutorialDeleteService deleteTutorialService;
	
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list-theory","list", this.theorylistService);
		super.addCommand("list-lab","list", this.lablistService);
		super.addCommand("show", this.showService);
		super.addCommand("create-theory","create", this.createTheoryService);
		super.addCommand("create-lab","create", this.createLabService);
		super.addCommand("update", this.updateTutorialService);
		super.addCommand("delete", this.deleteTutorialService);
 
	}
	
	
}
