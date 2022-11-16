package acme.entities.helpRequest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.tutorial.Tutorial;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Learner;
import acme.roles.Teacher;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HelpRequest extends AbstractEntity{
	
	    // Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		@NotNull
		protected Status 			status;
		
		
		@NotBlank
		@Column(unique=true)
		@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(:[A-Z]{1,10})?$")
		protected String			ticker;
		
		@NotBlank
		@Length(min=1,max=256)
		protected String 			statement;
		
		@NotNull
		protected Money 			budget;
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		protected Date 				startDate;
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		protected Date 				finishDate;
		
		@URL
		protected String			link;
		
		

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
		
		@NotNull
		@Valid
		@ManyToOne(optional = false)
		protected Teacher			teacher;
		
		@NotNull
		@Valid
		@ManyToOne(optional = false)
		protected Learner			learner;
		
		@NotNull
		@Valid
		@ManyToOne(optional = false)
		protected Tutorial			tutorial;
		
		
		

}
