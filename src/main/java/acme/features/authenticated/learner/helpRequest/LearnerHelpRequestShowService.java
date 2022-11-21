package acme.features.learner.helpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.helpRequest.HelpRequest;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Learner;

@Service
public class LearnerHelpRequestShowService implements AbstractShowService<Learner, HelpRequest>{

	@Autowired
	LearnerHelpRequestRepository repository;
	
	@Override
	public boolean authorise(final Request<HelpRequest> request) {
		assert request != null;

		Integer idLogin = request.getPrincipal().getActiveRoleId();
		int idTutorial = request.getModel().getInteger("id");
		HelpRequest t = this.repository.findHelpRequestById(idTutorial);
		Integer idOwner = t.getLearner().getId();
		
		
		return idLogin.equals(idOwner);
	}

	@Override
	public void unbind(final Request<HelpRequest> request, final HelpRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
		request.unbind(entity, model, "status","ticker", "statement","budget","startDate","finishDate", "link");
	}

	@Override
	public HelpRequest findOne(final Request<HelpRequest> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		
		return this.repository.findHelpRequestById(id);
	}

}
