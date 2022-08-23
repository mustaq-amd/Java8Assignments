package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.PasswordValidator;

public class PasswordValidatorTest {

	private static PasswordValidator passwordValidator;

	@BeforeClass
	public static void setUp() {
		passwordValidator = new PasswordValidator();
	}

	@Test
	public void testValidPassword() throws InfyAcademyException {
		boolean actualPass = passwordValidator.validatePassword("Asdf123");
		boolean expectedPass = false;
		assertEquals(actualPass, expectedPass);
	}

	@Test
	public void testInvalidPassword() throws InfyAcademyException {
		boolean actualPass = passwordValidator.validatePassword("Asdf");
		boolean expectedPass = false;
		assertEquals(actualPass, expectedPass);
	}

	@Test
	public void testInvalidPasswordException() throws InfyAcademyException {
		assertThrows(InfyAcademyException.class,
	            ()->{
	            	passwordValidator.validatePassword(null);
	            });
	
	}

	@ParameterizedTest
	@ValueSource(strings = { "Qwerty","Qwerty1234","Qwertyxdfgsdfdsfdsf","zxcv12365" })
	public void tParameterizedPassword(String abc) throws InfyAcademyException {
		assertNotNull(abc);
	}

	@AfterClass
	public static void teardown() {
		passwordValidator = null;
	}

}