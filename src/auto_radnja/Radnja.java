package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;
/**
 * Interfejs koji predstavlja radnju automobilskih guma
 * 
 * @author vlajko32
 * @version 0.2
 *
 */
public interface Radnja {
	/**
	 * Metoda koja dodaje novu gumu u radnju
	 * 
	 * @param a Nova guma klase AutoGuma koja treba da bude dodata
	 * 
	 * @throws java.lang.NullPointerException ukoliko je zadata guma null
	 * @throws java.lang.RuntimeException ukoliko zadata guma vec postoji
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Metoda koja pronalazi gume zadate marke i modela.
	 * 
	 * @param markaModel Marka i model gume kao String vrednost
	 * @return
	 * <ul>
	 * 		<li>null ako je zadati kriterijum pretrage markaModel jednak null.
	 * 		<li>nova lista koju cine gume zadate marke i modela.
	 * </ul>
	 */
	LinkedList<AutoGuma> pronadjiGumu (String markaModel);
	
	
	LinkedList<AutoGuma> vratiSveGume();
}
