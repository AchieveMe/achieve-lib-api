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
 * <p>Unit test class for {@link CNPJGenerator}.</p>
 * 
 * @author GAN
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class CNPJGeneratorTest extends GeneratorSuperTest {
	
	private boolean withNoPoints;
	private boolean withPoints;
	
	private String cnpjWithPoints;
	private String cnpjWithNoPoints;
	
	private List<String> listOfCNPJ;
	
	@Before
	public void setUp() {
		this.generator = CNPJGenerator.getInstance();
		this.listOfCNPJ = new ArrayList<>();
		this.withNoPoints = false;
		this.withPoints = true;
		this.cnpjWithPoints = generator.generateValueCNPJ(withPoints);
		this.cnpjWithNoPoints = generator.generateValueCNPJ(withNoPoints);
	}
	
	@After
	public void tearDown() {
		this.generator = null;
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
	
	@Test
	public void should_has_a_nice_performance_cnpj_with_points() {
		while (listOfCNPJ.size() <= 500) {
			cnpjWithPoints = generator.generateValueCNPJ(withPoints);
			System.out.println(cnpjWithPoints);
			listOfCNPJ.add(cnpjWithPoints);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_cnpj_with_no_points() {
		while (listOfCNPJ.size() <= 500) {
			cnpjWithNoPoints = generator.generateValueCNPJ(withNoPoints);
			System.out.println(cnpjWithNoPoints);
			listOfCNPJ.add(cnpjWithNoPoints);
		}
	}
}