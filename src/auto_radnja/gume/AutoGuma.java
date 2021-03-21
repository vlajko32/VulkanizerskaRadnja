package auto_radnja.gume;
/**
 * Klasa koja predstavlja automobilsku gumu i sadrzi sledece podatke o njoj:
 * marku, precnik, sirinu i visinu.
 * 
 * @author vlajko32
 * @version 0.1
 */
public class AutoGuma {
	
	/**
	 * Marka i model gume kao String.
	 */
	private String markaModel = null;	
	
	/**
	 * Precnik gume kao ceo broj.
	 */
	private int precnik = -1;
	
	/**
	 * Sirina gume kao ceo broj.
	 */
	private int sirina = -1;
	
	/**
	 * Visina gume kao ceo broj.
	 */
	private int visina = -1;
	
	/**
	 * Konstruktor koji inicijalizuje objekat i nista vise.
	 */
	public AutoGuma() {
		}
	
	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja odgovarajuce vrednosti za marku, precnik, sirinu i visinu.
	 * 
	 * @param markaModel Marka i model gume kao String.
	 * @param precnik Precnik gume kao ceo broj.
	 * @param sirina Sirina gume kao ceo broj.
	 * @param visina Visina gume kao ceo broj.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Vraca marku i model gume.
	 * 
	 * @return Marku i model gume kao String.
 	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Postavlja marku i model na novu vrednost.
	 * 
	 * @param markaModel Marka i model gume kao String.
	 * 
	 * @throws java.lang.NullPointerException ako je uneti String null.
	 * @throws java.lang.RuntimeException ako je uneti String ima manje od 3 znaka.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel==null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length()<3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	
	/**
	 * Vraca precnik gume.
	 * @return Precnik gume kao ceo broj.
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * Postavlja precnik gume na novu vrednost.
	 * 
	 * @param precnik Precnik gume kao ceo broj.
	 * @throws java.lang.RuntimeException ukoliko je precnik gume manji od 13 ili veci od 22.
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}
	
	/**
	 * Vraca sirinu gume.
	 * @return Sirinu gume kao ceo broj.
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Postavlja sirinu gume na novu vrednost
	 * 
	 * @param sirina Sirina gume kao ceo broj.
	 * @throws java.lang.RuntimeException ukoliko je sirina manja od 135 ili veca od 355.
	 */
	public void setSirina(int sirina) {
			if (sirina < 135 && sirina > 355)
				throw new RuntimeException("Sirina van opsega");
			this.sirina = sirina;
	}
	
	/**
	 * Vraca visinu gume.
	 * 
	 * @return Visinu gume kao ceo broj.
	 */
	public int getVisina() {
			return visina;
	}
	
	/**
	 * Postavlja visinu gume na novu vrednost.
	 * 
	 * @param visina Visina gume kao ceo broj.
	 * @throws java.lang.RuntimeException ukoliko je visina manja od 25 ili veca od 95.
	 */
	public void setVisina(int visina) {
			if (visina < 25 || visina > 95)
				throw new RuntimeException("Visina van opsega");
			this.visina = visina;
	}
	
	/**
	 * @return Vraca String sa svim podacima o gumi.
	 */
	@Override
	public String toString() {
			return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina=" + visina + "]";
	}
	
	/**
	 * Poredi dve gume i vraca true ako su iste, false ukoliko nisu.
	 * 
	 * Gume se porede po svim parametrima i svi parametri moraju biti isti da bi metoda vratila true.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true ukoliko su objekti po svim parametrima isti</li>
	 * 		<li>false u svim ostalim slucajevima</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AutoGuma other = (AutoGuma) obj;
			if (markaModel == null) {
				if (other.markaModel != null)
					return false;
			} else if (!markaModel.equals(other.markaModel))
				return false;
			if (precnik != other.precnik)
				return false;
			if (sirina != other.sirina)
				return false;
			if (visina != other.visina)
				return false;
			return true;
			}
}