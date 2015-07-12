package vc.achieve.api.commons.generator.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vc.achieve.api.commons.generator.GeneratorSuperTest;

/**
 * <p>Unit test class for {@link CPFGenerator}.</p>
 * 
 * @author GAN
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class CPFGeneratorTest extends GeneratorSuperTest {
	
	private boolean withNoPoints;
	private boolean withPoints;
	
	private String cpfWithPoints;
	private String cpfWithNoPoints;
	
	private List<String> listOfCPF;
	
	@Before
	public void setUp() {
		this.generator = CPFGenerator.getInstance();
		this.listOfCPF = new ArrayList<>();
		this.withNoPoints = false;
		this.withPoints = true;
		this.cpfWithPoints = generator.generateValueCPF(withPoints);
		this.cpfWithNoPoints = generator.generateValueCPF(withNoPoints);
	}

	@After
	public void tearDown() {
		this.generator = null;
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
	
	@Test
	public void should_has_a_nice_performance_cpf_with_points() {
		while (listOfCPF.size() <= 500) {
			cpfWithPoints = generator.generateValueCPF(withPoints);
			System.out.println(cpfWithPoints);
			listOfCPF.add(cpfWithPoints);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_cpf_with_no_points() {
		while (listOfCPF.size() <= 500) {
			cpfWithNoPoints = generator.generateValueCPF(withNoPoints);
			System.out.println(cpfWithNoPoints);
			listOfCPF.add(cpfWithNoPoints);
		}
	}
}