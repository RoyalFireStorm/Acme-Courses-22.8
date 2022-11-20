package acme.features.learner.helpRequest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.helpRequest.HelpRequest;
import acme.framework.controllers.AbstractController;
import acme.roles.Learner;

@Controller
public class LearnerHelpRequestController extends AbstractController<Learner, HelpRequest>{

	@Autowired
	private LearnerHelpRequestListService listService;
	
	@Autowired
	private LearnerHelpRequestShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
