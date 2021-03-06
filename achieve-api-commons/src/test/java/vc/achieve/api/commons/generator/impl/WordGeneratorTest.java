package vc.achieve.api.commons.generator.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vc.achieve.api.commons.generator.GeneratorSuperTest;

/**
 * <p>Unit test class for {@link WordGenerator}.</p>
 * 
 * @author GAN
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class WordGeneratorTest extends GeneratorSuperTest {

	private int maxChar;
	private boolean onlyLetter = true;
	private boolean letter = false;
	
	private String wordOnlyLetter;
	private String word;
	
	private Random random;
	
	private List<String> listOfWord;
	
	@Before
	public void setUp() {
		this.random = new Random();
		this.generator = WordGenerator.getInstance();
		this.listOfWord = new ArrayList<>();
		this.maxChar = random.nextInt(1000);
		this.wordOnlyLetter = generator.generateValue(maxChar, onlyLetter);
		this.word = generator.generateValue(maxChar, letter);
	}

	@After
	public void tearDown() {
		this.random = null;
		this.generator = null;
		this.listOfWord = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(wordOnlyLetter, is(notNullValue()));
		assertThat(word, is(notNullValue()));
	}

	@Test
	public void should_has_a_nice_performance_word_only_letter() {
		while (listOfWord.size() <= 500) {
			listOfWord.add(wordOnlyLetter);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_word() {
		while (listOfWord.size() <= 500) {
			listOfWord.add(word);
		}
	}
}