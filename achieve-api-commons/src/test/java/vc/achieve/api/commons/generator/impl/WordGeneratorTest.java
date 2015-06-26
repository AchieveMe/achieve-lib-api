package vc.achieve.api.commons.generator.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vc.achieve.api.commons.generator.GeneratorSuperTest;

/**
 * <p>Unit test class for {@link WordGenerator}.</p>
 * 
 * @author GAN
 * @since 1.0
 */
public class WordGeneratorTest extends GeneratorSuperTest {

	private int maxChar = 3;
	private boolean onlyLetter = true;
	private boolean letter = true;
	
	private String wordGeneratedOnlyLetter;
	private String wordGenerated;
	
	@Before
	public void setUp() {
		this.generator = WordGenerator.getInstance();
		this.wordGeneratedOnlyLetter = generator.generateValue(maxChar, onlyLetter);
		this.wordGenerated = generator.generateValue(maxChar, letter);
	}

	@After
	public void tearDown() {
		this.generator = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(wordGeneratedOnlyLetter, is(notNullValue()));
		assertThat(wordGenerated, is(notNullValue()));
	}

}