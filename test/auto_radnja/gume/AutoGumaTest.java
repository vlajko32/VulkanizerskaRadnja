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
		a = new AutoGuma("GoodYear",15,150,50);
		assertNotNull(a);
		assertEquals(15,a.getPrecnik());
		assertEquals("GoodYear",a.getMarkaModel());
		assertEquals(150,a.getSirina());
		assertEquals(50,a.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("GoodYear");
		assertEquals("GoodYear",a.getMarkaModel());
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
		"13",
		"15",
		"22"
	})
	void testSetPrecnik(int pr) {
		
		a.setPrecnik(pr);
		assertEquals(pr,a.getPrecnik());
	}

	
	@ParameterizedTest
	@CsvSource({
		"50",
		"40",
		"23"
	})
	void testSetPrecnikVeciOdDozvoljenog(int pr) {
		
	assertThrows(java.lang.RuntimeException.class, ()->a.setPrecnik(pr));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"7",
		"5",
		"11"
	})
	void testSetPrecnikManjiOdDozvoljenog(int pr) {
		
	assertThrows(java.lang.RuntimeException.class, ()->a.setPrecnik(pr));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"150",
		"180",
		"220"
	})
	void testSetSirina(int pr) {
		
		a.setSirina(pr);
		assertEquals(pr,a.getSirina());
		
	}

	@ParameterizedTest
	@CsvSource({
		"400",
		"500",
		"620"
	})
	void testSetSirinaVecaOdDozvoljene(int pr) {
		
		assertThrows(java.lang.RuntimeException.class, ()->a.setSirina(pr));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"15",
		"18",
		"45"
	})
	void testSetSirinaManjaOdDozvoljene(int pr) {
		
		assertThrows(java.lang.RuntimeException.class, ()->a.setSirina(pr));
		
	}


	@ParameterizedTest
	@CsvSource({
		"50",
		"35",
		"75"
	})
	void testSetVisina(int pr) {
		
		a.setVisina(pr);
		assertEquals(pr,a.getVisina());
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"12",
		"5",
		"10"
	})
	void testSetVisinaManjaOdDozvoljene(int pr) {
		
		assertThrows(java.lang.RuntimeException.class, () ->a.setVisina(pr) );
		
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"110",
		"130",
		"120"
	})
	void testSetVisinaVecaOdDozvoljene(int pr) {
		
		assertThrows(java.lang.RuntimeException.class, () ->a.setVisina(pr) );
		
	}

	@Test
	void testToString() {
		a.setMarkaModel("GoodYear");
		a.setPrecnik(18);
		a.setSirina(200);
		a.setVisina(50);
		
		String str = a.toString();
		assertTrue(str.contains("GoodYear"));
		assertTrue(str.contains("18"));
		assertTrue(str.contains("200"));
		assertTrue(str.contains("50"));
	}

	@ParameterizedTest
	@CsvSource({
		"GoodYear 12,18,200,50,GoodYear 12,18,200,50,true",
		"GoodYear 12,18,250,60,GoodYear 12,18,200,50,false",
		"GoodYear 12,19,250,60,GoodYear 12,18,250,50,false",
		"GoodYear 12,18,200,60,GoodYear 11,18,200,50,false"
	})
	void testEqualsObject(String st1,int pr1,int s1, int v1, String st2,int pr2, int s2, int v2, boolean eq) {
		a = new AutoGuma(st1, pr1, s1, v1);
		AutoGuma b = new AutoGuma(st2,pr2,s2,v2);
		assertEquals(eq,a.equals(b));
	}

}
