package FrontEnd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import services.UserService;



public class HelloMockitoExamle {
//	class ConverterTest {
		Converter convert;

		/*
			A MOCK is a fake object based on a real object; the mock has "empty" methods with the same names as
				the real object HOWEVER the mock's methods simply return the default values of the return datatype.
				The mock is able to intercept specific method calls and temporarily return a predetermined value.
			
			A SPY is a fake object based on a real object; unlike a mock, a spy has methods with the same names as
				the real object HOWEVER the spy's methods aren't empty. Though, you can STILL tell the spy to
				intercept specific method calls and temporarily return a predetermined value.
				
			To put it another way a SPY is just a partial MOCK.

			A STUB is a essentially a mock that does NOT have the ability to fail tests. The mock we created in this example
				is able to fail the test with the verify() functionality, but a stub wouldn't be able to fail a test.
				A STUB is a very simple "fake".
				
			All of these entities are called "fakes".
			
		*/
		//HERE, Mockito will create a FAKE ConverterHelper object.
		//This fake object is called a "mock", this process is called "mocking"
		// (also look into mocks vs spies)
		UserService UserSer = Mockito.mock(UserService.class);

		@BeforeEach
		void setUp() throws Exception {
//			convert = new Converter(new ConverterHelper());
//			OR
			convert = new Converter(coworkerObjectMock);
		}

		@Test
		void test() {
			
			/////////ARRANGE
			//HERE, we will tell this SPECIFIC mock to give us a SPECIFIC value when a SPECIFIC method is called
			Mockito.when(coworkerObjectMock.findMilesToFeetMultiplier(2+100)).thenReturn(5280);
			Mockito.when(coworkerObjectMock.findMilesToFeetMultiplier(5+100)).thenReturn(5280);
			
			/////////ACT
			int twoMiles = convert.howManyFeet(2);
			int fiveMiles = convert.howManyFeet(5);
			
			//////////ASSERT
			assertEquals(2*5280, twoMiles);
			assertEquals(5*5280, fiveMiles);
			//verifying checks for method invocations
			Mockito.verify(coworkerObjectMock, Mockito.times(2)).findMilesToFeetMultiplier(2+100);
			Mockito.verify(coworkerObjectMock, Mockito.times(2)).findMilesToFeetMultiplier(5+100);
			
			System.out.println("what's the state of the OTHER mocked methods (pi)? "+coworkerObjectMock.findPi());	
			System.out.println("what's the state of the OTHER mocked methods (other)? "+coworkerObjectMock.mocksDefaultValueTwo());

//			Mockito.verify(helperMock, Mockito.atLeastOnce()).findMilesToFeetMultiplier(5+100);
//			Mockito.verify(helperMock, Mockito.atMost(5)).findMilesToFeetMultiplier(5+100);
//			Mockito.verify(helperMock, Mockito.atLeast(3)).findMilesToFeetMultiplier(5+100);
//			Mockito.verify(helperMock, Mockito.never()).findMilesToFeetMultiplier(5+100);
//			Mockito.verify(helperMock, Mockito.any()).findMilesToFeetMultiplier(5+100);
		}

	}

