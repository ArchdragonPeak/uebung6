import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtikelTest {
	private Artikel artikel;

	@BeforeEach
	void setUp() throws Exception {
		this.artikel = new Artikel(110, "Parkett Eiche geräuchert", 69.9);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.artikel = null;
	}

	@Test
	void test() {
		double erg;
// Testfall: anzahlKaufArtikel < 0
		try {
			this.artikel.berechnePreisJeArtikel(-1);
			fail("Exception: 'Anzahl darf nicht negativ sein' fehlt.");
		} catch (Exception exc) {
		}
// Testfall: anzahlKaufArtikel = 0
		try {
			this.artikel.berechnePreisJeArtikel(0);
			fail("Exception: 'Anzahl darf nicht 0 sein' fehlt.");
		} catch (Exception exc) {
		}
// Testfall: anzahlKaufArtikel ist 500 oder 1000
		erg = this.artikel.berechnePreisJeArtikel(500);
		assertEquals(52.425, erg, 0.001);
		erg = this.artikel.berechnePreisJeArtikel(1000);
		assertEquals(41.94, erg, 0.001);
// Testfall: anzahlKaufArtikel zwischen x-Werten zweier Punkte
		erg = this.artikel.berechnePreisJeArtikel(600);
		assertEquals(50.328, erg, 0.001);
// Testfall: anzahlKaufArtikel ist groesser als 1000
		erg = this.artikel.berechnePreisJeArtikel(1001);
		assertEquals(41.94, erg, 0.001);
	}
}