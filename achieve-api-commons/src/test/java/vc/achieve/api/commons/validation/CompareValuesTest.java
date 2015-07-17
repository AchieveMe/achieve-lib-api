package vc.achieve.api.commons.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>Unit test class for {@link CompareValues}.</p>
 * 
 * @author GAN
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class CompareValuesTest {
	
	private Validator validator;
	
	@Before
	public void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@After
	public void tearDown() {
		validator = null;
	}

	@Test
	public void should_test_with_string_valid_comparision() {
		Set<ConstraintViolation<ValidUserComparision>> validComparitionBetweenValues = validator.validate(new ValidUserComparision());
		
		assertThat(validComparitionBetweenValues.isEmpty(), is(true));
	}
	
	@Test
	public void should_test_with_string_invalid_comparision() {
		Set<ConstraintViolation<invalidUserComparision>> invalidComparitionBetweenValues = validator.validate(new invalidUserComparision());
		
		assertThat(invalidComparitionBetweenValues.isEmpty(), is(false));
	}
	
	@Test
	public void should_test_with_date_invalid_comparision() {
		Set<ConstraintViolation<InvalidDateComparision>> invalidComparitionBetweenValues = validator.validate(new InvalidDateComparision());
		
		assertThat(invalidComparitionBetweenValues.isEmpty(), is(false));
	}
	
	/**
	 * <p>Unit test class to compare.</p>
	 * 
	 * @author GAN
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	@CompareValues(propertyNames={"email", "emailToConfirm"})
	public class ValidUserComparision {

		String email = "guiandmag@gmail.com";
		String emailToConfirm = "guiandmag@gmail.com";
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEmailToConfirm() {
			return emailToConfirm;
		}
		public void setEmailToConfirm(String emailToConfirm) {
			this.emailToConfirm = emailToConfirm;
		}
	}
	
	/**
	 * <p>Unit test class to compare.</p>
	 * 
	 * @author GAN
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	@CompareValues(propertyNames={"email", "emailToConfirm"})
	public class invalidUserComparision {

		String email = "alberto.cerqueira1990@gmail.com";
		String emailToConfirm = "alberto.cerqueira1990@gmail";
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEmailToConfirm() {
			return emailToConfirm;
		}
		public void setEmailToConfirm(String emailToConfirm) {
			this.emailToConfirm = emailToConfirm;
		}
	}
	
	/**
	 * <p>Unit test class to compare.</p>
	 * 
	 * @author GAN
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	@CompareValues(propertyNames = {"dateFrom", "dateTo"})
	public class InvalidDateComparision {

		Date dateFrom = new GregorianCalendar(2025, 10, 10).getTime();
        Date dateTo = new GregorianCalendar(2020, 10, 10).getTime();

        public Date getDateFrom() {
            return dateFrom;
        }
        public void setDateFrom(Date dateFrom) {
            this.dateFrom = dateFrom;
        }
        public Date getDateTo() {
            return dateTo;
        }
        public void setDateTo(Date dateTo) {
            this.dateTo = dateTo;
        }
	}
}