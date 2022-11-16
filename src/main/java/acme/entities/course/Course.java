package acme.entities.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course extends AbstractEntity{
	
	    // Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		
		@NotBlank
		@Length(min=1,max=76)
		protected String			caption;
		
		@NotBlank
		@Column(unique=true)
		@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(:[A-Z]{1,10})?$")
		protected String			ticker;
		
		@NotBlank
		@Length(min=1,max=256)
		protected String			abstractMessage;
		
		
		@URL
		protected String			link;
		
		

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
		
		
		

}
