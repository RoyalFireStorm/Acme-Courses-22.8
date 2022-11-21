package acme.features.authenticated.learner.followUp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.followUp.FollowUp;
import acme.entities.helpRequest.HelpRequest;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Learner;

@Service
public class LearnerFollowUpListService implements AbstractListService<Learner, FollowUp>{
	
	@Autowired
	LearnerFollowUpRepository repository;
	
	@Override
	public boolean authorise(final Request<FollowUp> request) {
		assert request != null;
		
		Integer idLogin = request.getPrincipal().getActiveRoleId();
		int idHelpRequest = request.getModel().getInteger("id");
		HelpRequest t = this.repository.findHelpRequestById(idHelpRequest);
		Integer idOwner = t.getLearner().getId();
		
		
		return idLogin.equals(idOwner);
	}

	@Override
	public void unbind(final Request<FollowUp> request, final FollowUp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model,"sequenceNumber","moment", "message", "link");
	}

	@Override
	public Collection<FollowUp> findMany(final Request<FollowUp> request) {
		assert request != null;
		
		Collection<FollowUp> result;
		int idRole = request.getPrincipal().getActiveRoleId();
		int idHelpRequest = request.getModel().getInteger("id");
		
		
		result= this.repository.findAllMyFollowUps(idRole, idHelpRequest);
				
		return result;
	}

}
