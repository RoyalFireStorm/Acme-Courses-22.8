package acme.features.authenticated.post;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.post.Post;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedPostListService implements AbstractListService<Authenticated, Post>{

	@Autowired
	AuthenticatedPostRepository repository;
	
	@Override
	public boolean authorise(final Request<Post> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Post> request, final Post entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "moment","caption", "informational","message", "link");
	}

	@Override
	public Collection<Post> findMany(final Request<Post> request) {
		assert request != null;
		
		Collection<Post> result;
		final LocalDate time = LocalDate.now().minusMonths(1);
		result = this.repository.findLessThanAMonth(time);
		
		return result;
	}

}
