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
 * <p>Unit test class for {@link CPFGenerator}.</p>
 * 
 * @author GAN
 * @since 1.0
 */
@RunWith(JUnit4.class)
public class CPFGeneratorTest {
	
	private boolean withNoPoints;
	private boolean withPoints;
	
	private String cpfWithPoints;
	private String cpfWithNoPoints;
	
	private List<String> listOfCPF;
	
	private CPFGenerator cpf;

	@Before
	public void setUp() {
		this.cpf = CPFGenerator.getInstance();
		this.listOfCPF = new ArrayList<>();
		this.withNoPoints = false;
		this.withPoints = true;
		this.cpfWithPoints = cpf.generateValue(withPoints);
		this.cpfWithNoPoints = cpf.generateValue(withNoPoints);
	}

	@After
	public void tearDown() {
		this.cpf = null;
		this.listOfCPF = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(cpfWithPoints, is(notNullValue()));
		assertThat(cpfWithNoPoints, is(notNullValue()));
	}
	
	@Test
	public void should_get_the_value_and_show_its_diferent() {
		assertThat(cpfWithPoints, is(not(equals(cpfWithNoPoints))));
	}
	
	@Test(timeout=10)
	public void should_has_a_nice_performance_cnpj_with_points() {
		while (listOfCPF.size() <= 500) {
			cpfWithPoints = cpf.generateValue(withPoints);
			
			listOfCPF.add(cpfWithPoints);
		}
	}
	
	@Test(timeout=10)
	public void should_has_a_nice_performance_cnpj_with_no_points() {
		while (listOfCPF.size() <= 500) {
			cpfWithNoPoints = cpf.generateValue(withNoPoints);
			
			listOfCPF.add(cpfWithNoPoints);
		}
	}
}