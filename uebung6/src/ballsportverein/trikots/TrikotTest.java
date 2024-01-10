package ballsportverein.trikots;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TrikotTest {
	private Trikot trikot;

	@BeforeEach
	void setUp() throws Exception {
		this.trikot = new Trikot(1, 42, -49.90, 20140701);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.trikot = null;
	}

	@Test
	void testUeberpruefePreis() {
// Testfall: Der vorgegebene Preis ist kleiner als 0, mit
// void assertTrue(boolean condition, String message)
		Assertions.assertTrue(this.trikot.ueberpruefePreis() == false, "Das Ergebnis muss false ergeben");
// Testfall: Der vorgegebene Preis ist gleich 0, mit
// void assertTrue(BooleanSupplier booleanSupplier, 
// String message)
		this.trikot.setPreis(0);
		assertTrue(() -> this.trikot.ueberpruefePreis() == true, "Das Ergebnis muss true ergeben");
// Testfall: Der vorgegebene Preis ist groesser als 0, mit
// void assertTrue(BooleanSupplier booleanSupplier, 
// Supplier<String> messageSupplier)
		this.trikot.setPreis(10);
		assertTrue(() -> this.trikot.ueberpruefePreis() == true, () -> "Das Ergebnis muss true ergeben");
	}

	@Test
	void testTrikot() {
		Throwable exc = assertThrows(IllegalArgumentException.class, () -> {
			new Trikot(-1, 40, 29.99, 20220919);
		});
		assertEquals("Die Trikotnummer darf nicht 0 oder negativ sein.", exc.getMessage());
	}
}
