package vc.achieve.api.commons.generator.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vc.achieve.api.commons.generator.GeneratorSuperTest;

/**
 * <p>Unit test class for {@link PlateGenerator}.</p>
 * 
 * @author GAN
 * @since 1.0
 */
public class PlateGeneratorTest extends GeneratorSuperTest {
	
	private String plateGenerated;

	@Before
	public void setUp() {
		this.generator = PlateGenerator.getInstance();
		this.plateGenerated = generator.generateValue();
	}

	@After
	public void tearDown() {
		this.generator = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(plateGenerated, is(notNullValue()));
	}

	//Make more assertions
}