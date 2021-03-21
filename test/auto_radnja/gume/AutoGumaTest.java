package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	AutoGuma a;
	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAutoGuma() {
		assertNotNull(a);
	}

	@Test
	@DisplayName("Testira rad konstruktora sa parametrima")
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("modelMarka",15,150,50);
		assertNotNull(a);
		assertEquals(15,a.getPrecnik());
		assertEquals("modelMarka",a.getMarkaModel());
		assertEquals(150,a.getSirina());
		assertEquals(50,a.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("markaModel");
		assertEquals("markaModel",a.getMarkaModel());
	}
	
	@Test
	@DisplayName("Testira ako je uneto null kao model i marka gume")
	void testSetMarkaModelNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->a.setMarkaModel(null));
	}
	
	@Test
	@DisplayName("Testira ako je unet kratak String za model i marku gume")
	void testSetMarkaModelDuzinaStringa() {
		
		assertThrows(java.lang.RuntimeException.class, ()->a.setMarkaModel("aa"));
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"15",
		"5",
		"25"
	})
	void testSetPrecnik(int pr) {
		if(pr<13)
		{
			assertThrows(java.lang.RuntimeException.class, ()->a.setPrecnik(pr));
		}
		else if(pr>22) {
			assertThrows(java.lang.RuntimeException.class, ()->a.setPrecnik(pr));
		}else{
		a.setPrecnik(pr);
		assertEquals(pr,a.getPrecnik());
		}
	}
	
	
	
	@ParameterizedTest
	@CsvSource({
		"15",
		"180",
		"450"
	})
	void testSetSirina(int pr) {
		if(pr<135)
		{
			assertThrows(java.lang.RuntimeException.class, ()->a.setSirina(pr));
		}
		else if(pr>355) {
			assertThrows(java.lang.RuntimeException.class, ()->a.setSirina(pr));
		}else {
		a.setSirina(pr);
		assertEquals(pr,a.getSirina());
		}
	}

	@ParameterizedTest
	@CsvSource({
		"50",
		"5",
		"120"
	})
	void testSetVisina(int pr) {
		if(pr<25)
		{
			assertThrows(java.lang.RuntimeException.class, () -> a.setVisina(pr) );
		}
		else if(pr>95) {
			assertThrows(java.lang.RuntimeException.class, () ->a.setVisina(pr) );
		}else {
		a.setVisina(pr);
		assertEquals(pr,a.getVisina());
		}
	}

	@Test
	void testToString() {
		a.setMarkaModel("markaModel");
		a.setPrecnik(18);
		a.setSirina(200);
		a.setVisina(50);
		
		String str = a.toString();
		assertTrue(str.contains("marka"));
		assertTrue(str.contains("18"));
		assertTrue(str.contains("200"));
		assertTrue(str.contains("50"));
	}

	@ParameterizedTest
	@CsvSource({
		"markaModel,18,200,50,markaModel,18,200,50,true",
		"markaModel,18,250,60,markaModel,18,200,50,false",
		"markaModel,19,250,60,markaModel,18,250,50,false",
		"markaModl,18,200,60,markaModel,18,200,50,false"
	})
	void testEqualsObject(String st1,int pr1,int s1, int v1, String st2,int pr2, int s2, int v2, boolean eq) {
		a = new AutoGuma(st1, pr1, s1, v1);
		AutoGuma b = new AutoGuma(st2,pr2,s2,v2);
		assertEquals(eq,a.equals(b));
	}

}
