package acme.features.any.blink;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.blink.Blink;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyBlinkController extends AbstractController<Any, Blink>{

	@Autowired
	private AnyBlinkListService listService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
 
	}
	
	
}
