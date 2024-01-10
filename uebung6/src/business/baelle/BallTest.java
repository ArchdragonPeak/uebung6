package business.baelle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class BallTest {
	private Ball ball;

	@BeforeEach
	void setUp() throws Exception {
		this.ball = new Ball(20140601, "Leder", null, "in Gebrauch", "Spiel", -59.99);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.ball = null;
	}

	@Test
	void test() {
// Testfall: Die vorgegebene Sportart ist null, mit
// void assertTrue(boolean condition, String message)
		assertTrue(this.ball.ueberpruefeSportart() == false, "Das Ergebnis muss false ergeben");
// Testfall: Die vorgegebene Sportart ist nicht null, mit
// void assertTrue(boolean condition, 
// Supplier<String> messageSupplier)
		this.ball.setSportart("Fußball");
		assertTrue(this.ball.ueberpruefeSportart() == true, (() -> "Das Ergebnis muss true ergeben."));
	}
}
