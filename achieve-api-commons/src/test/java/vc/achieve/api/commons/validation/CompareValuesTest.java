package vc.achieve.api.commons.validation;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
 * @author GAN
 *
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
	public void should_test_with_valid_comparision() {
		Set<ConstraintViolation<ValidUserComparision>> validComparitionBetweenValues = validator.validate(new ValidUserComparision());
		
		assertThat(validComparitionBetweenValues.isEmpty(), is(true));
	}
	
	@Test
	public void should_test_with_invalid_comparision() {
		Set<ConstraintViolation<InvalidDateComparision>> invalidComparitionBetweenValues = validator.validate(new InvalidDateComparision());
		
		for (ConstraintViolation<InvalidDateComparision> invalidComparitionBetweenValue : invalidComparitionBetweenValues) {
			System.out.println(invalidComparitionBetweenValue.getMessage());
		}
		
		assertThat(invalidComparitionBetweenValues.isEmpty(), is(false));
	}

	
	/**
	 * @author GAN
	 *
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
	 * 
	 * @author GAN
	 *
	 */
	@CompareValues(propertyNames = {"dateFrom", "dateTo"})
	public class InvalidDateComparision {

		Date dateFrom = new GregorianCalendar(2015,10,10).getTime();
        Date dateTo = new GregorianCalendar(2020,10,10).getTime();

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
