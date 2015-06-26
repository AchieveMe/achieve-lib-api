package vc.achieve.api.commons.generator.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vc.achieve.api.commons.generator.GeneratorSuperTest;

/**
 * <p>Unit test class for {@link PasswordGenerator}.</p>
 * 
 * @author GAN
 * @since 1.0
 */
public class PasswordGeneratorTest extends GeneratorSuperTest {
	
	private int maxChar;
	private int level;
	
	private String passwordGenerated;
	
	@Before
	public void setUp() {
		this.maxChar = 10;
		this.level = 5;
		this.generator = PasswordGenerator.getInstance();
		this.passwordGenerated = generator.generateValue(maxChar, level);
	}

	@After
	public void tearDown() {
		this.generator = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(passwordGenerated, is(notNullValue()));
	}

	//Make more assertions
}