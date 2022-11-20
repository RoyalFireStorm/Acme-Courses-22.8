package acme.features.authenticated.post;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.post.Post;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedPostController extends AbstractController<Authenticated, Post>{

	@Autowired
	private AuthenticatedPostListService listService;
	
	@Autowired
	private AuthenticatedPostShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
 
	}
	
	
}
 