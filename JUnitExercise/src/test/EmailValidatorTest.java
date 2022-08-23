package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;


public class EmailValidatorTest {
	
	private EmailValidator emailValidator; 

	@BeforeEach
	public void setUp() {
		emailValidator = new EmailValidator();
	}
	
	@Test
	public void testValidEmailId() throws InfyAcademyException {
		
		boolean actualEmail=emailValidator.validateEmailId("james_potteer@infy.com");
		boolean expectedValue=false;
		assertEquals(actualEmail,expectedValue);
	}

	@Test
	public void testInvalidEmailId() throws InfyAcademyException {
		boolean actualEmail=emailValidator.validateEmailId("james_potteer@infy.org");
		boolean expectedValue=false;
		assertEquals(actualEmail,expectedValue);
	}

	@Test
	public void testInvalidEmailIdException() throws InfyAcademyException {
		 assertThrows(InfyAcademyException.class,
		            ()->{
		            	
		            	boolean actualEmail=emailValidator.validateEmailId(null);
		            });
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "serius_black","Lily_Evans@Hoggy.in","Remus_lups","NymphieTonks@magic.com" })
	public void tParamterizedEmailId(String abc) throws InfyAcademyException {
		assertNotNull(abc);
	}
	
	@AfterEach
	public void teardown() {
		emailValidator = null;
	}
}
