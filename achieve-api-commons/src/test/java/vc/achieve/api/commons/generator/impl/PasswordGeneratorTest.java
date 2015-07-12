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
 * <p>Unit test class for {@link PasswordGenerator}.</p>
 * 
 * @author GAN
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class PasswordGeneratorTest extends GeneratorSuperTest {
	
	private int maxChar;
	private int level;
	
	private String password;
	
	private List<String> listOfPassword;
	
	@Before
	public void setUp() {
		this.generator = PasswordGenerator.getInstance();
		this.listOfPassword = new ArrayList<>();
		this.maxChar = 10;
		this.level = 5;
		this.password = generator.generateValue(maxChar, level);
	}

	@After
	public void tearDown() {
		this.generator = null;
		this.listOfPassword = null;
	}

	@Test
	public void should_get_value_and_assert_not_null() {
		assertThat(password, is(notNullValue()));
	}

	@Test
	public void should_get_the_value_and_show_its_diferent() {
		assertThat(password, is(not(equals(password))));
	}
	
	@Test
	public void should_has_a_nice_performance_password_level_1() {
		while (listOfPassword.size() <= 500) {
			password = generator.generateValue(maxChar, 1);
			System.out.println(password);
			listOfPassword.add(password);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_password_level_2() {
		while (listOfPassword.size() <= 500) {
			password = generator.generateValue(maxChar, 2);
			System.out.println(password);
			listOfPassword.add(password);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_password_level_3() {
		while (listOfPassword.size() <= 500) {
			password = generator.generateValue(maxChar, 3);
			System.out.println(password);
			listOfPassword.add(password);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_password_level_4() {
		while (listOfPassword.size() <= 500) {
			password = generator.generateValue(maxChar, 4);
			System.out.println(password);
			listOfPassword.add(password);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_password_level_5() {
		while (listOfPassword.size() <= 500) {
			password = generator.generateValue(maxChar, 5);
			System.out.println(password);
			listOfPassword.add(password);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_password_level_6() {
		while (listOfPassword.size() <= 500) {
			password = generator.generateValue(maxChar, 6);
			System.out.println(password);
			listOfPassword.add(password);
		}
	}
	
	@Test
	public void should_has_a_nice_performance_password_level_7() {
		while (listOfPassword.size() <= 500) {
			password = generator.generateValue(maxChar, 7);
			System.out.println(password);
			listOfPassword.add(password);
		}
	}
}