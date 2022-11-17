package acme.features.any.tutorial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tutorial.Tutorial;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyTutorialController extends AbstractController<Any, Tutorial>{

	@Autowired
	private AnyTheoryTutorialListService theorylistService;
	
	@Autowired
	private AnyLabTutorialListService lablistService;
	
	@Autowired
	private AnyTutorialShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list-theory","list", this.theorylistService);
		super.addCommand("list-lab","list", this.lablistService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
