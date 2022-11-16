package acme.entities.tutorial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tutorial extends AbstractEntity{
	
	    // Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		
		@NotBlank
		protected String			title;
		
		@Column(unique=true)
		@NotBlank
		@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(:[A-Z]{1,10})?$")
		protected String			ticker;
		
		@NotBlank
		protected String			abstractMessage;
		
		@NotNull
		protected Money				cost;
		
		@URL
		protected String			link;
		
		@NotNull
		protected TutorialType		type;
		
		

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
		
		
		

}