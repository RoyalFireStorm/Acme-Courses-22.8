package acme.features.administrator.post;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.post.Post;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdministratorPostController extends AbstractController<Administrator, Post>{

	@Autowired
	private AdministratorPostCreateService createService;
	
	
	@PostConstruct
	private void initialise() {
		super.addCommand("create", this.createService);
		
 
	}
	
	
}
 