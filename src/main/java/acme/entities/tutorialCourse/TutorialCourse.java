package acme.entities.tutorialCourse;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import acme.entities.course.Course;
import acme.entities.tutorial.Tutorial;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TutorialCourse extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		
		@NotNull
		@Positive
		protected Double duration;
		
		@NotNull
		protected TimeUnit timeUnit;
		
		@NotNull
		@Valid
		@ManyToOne(optional = false)
		protected Tutorial tutorial;
		
		@NotNull
		@Valid
		@ManyToOne(optional = false)
		protected Course course;
		

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
		
		// Functions --------------------------------------------------------------
		
}
