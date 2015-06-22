package vc.achieve.api.commons.generator;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Unit test class for {@link CNPJGenerator}.</p>
 * 
 * @author GAN
 * @since 1.0
 */
@RunWith(JUnit4.class)
public class CNPJGeneratorTest {
	
	private boolean withNoPoints;
	private boolean withPoints;
	
	private String cnpjWithPoints;
	private String cnpjWithNoPoints;
	
	private List<String> listOfCNPJ;
	
	private CNPJGenerator cnpj;
	
	@Before
	public void setUp() {
		this.cnpj = CNPJGenerator.getInstance();
		this.listOfCNPJ = new ArrayList<>();
		this.withNoPoints = false;
		this.withPoints = true;
		this.cnpjWithPoints = cnpj.generateValue(withPoints);
		this.cnpjWithNoPoints = cnpj.generateValue(withNoPoints);
	}
	
	@After
	public void tearDown() {
		this.cnpj = null;
		this.listOfCNPJ = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(cnpjWithPoints, is(notNullValue()));
		assertThat(cnpjWithNoPoints, is(notNullValue()));
	}
	
	@Test
	public void should_get_the_value_and_show_its_diferent() {
		assertThat(cnpjWithPoints, is(not(equals(cnpjWithNoPoints))));
	}
	
	@Test(timeout=10)
	public void should_has_a_nice_performance_cnpj_with_points() {
		while (listOfCNPJ.size() <= 500) {
			cnpjWithPoints = cnpj.generateValue(withPoints);
			
			listOfCNPJ.add(cnpjWithPoints);
		}
	}
	
	@Test(timeout=10)
	public void should_has_a_nice_performance_cnpj_with_no_points() {
		while (listOfCNPJ.size() <= 500) {
			cnpjWithNoPoints = cnpj.generateValue(withNoPoints);
			
			listOfCNPJ.add(cnpjWithNoPoints);
		}
	}
}