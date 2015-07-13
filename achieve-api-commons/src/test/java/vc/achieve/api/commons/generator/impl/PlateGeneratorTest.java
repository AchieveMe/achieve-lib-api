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
 * <p>Unit test class for {@link PlateGenerator}.</p>
 * 
 * @author GAN
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class PlateGeneratorTest extends GeneratorSuperTest {
	
	private String plate;
	
	private List<String> listOfPlate;

	@Before
	public void setUp() {
		this.generator = PlateGenerator.getInstance();
		this.listOfPlate = new ArrayList<>();
		this.plate = generator.generateValue();
	}

	@After
	public void tearDown() {
		this.generator = null;
		this.listOfPlate = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(plate, is(notNullValue()));
	}

	@Test
	public void should_has_a_nice_performance_plate() {
		while (listOfPlate.size() <= 500) {
			plate = generator.generateValue();
			
			listOfPlate.add(plate);
		}
	}
}