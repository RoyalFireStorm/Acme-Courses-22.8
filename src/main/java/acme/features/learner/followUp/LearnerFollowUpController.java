package acme.features.learner.followUp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.followUp.FollowUp;
import acme.framework.controllers.AbstractController;
import acme.roles.Learner;

@Controller
public class LearnerFollowUpController extends AbstractController<Learner, FollowUp>{

	@Autowired
	private LearnerFollowUpListService listService;
	
	@Autowired
	private LearnerFollowUpShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
