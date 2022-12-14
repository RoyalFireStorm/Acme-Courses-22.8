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
	
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list-theory","list", this.theorylistService);
		super.addCommand("list-lab","list", this.lablistService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
