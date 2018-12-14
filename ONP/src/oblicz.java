import java.util.Stack;

import java.util.StringTokenizer;

public class oblicz {
	private double wynik = 0;
	private boolean czujnik = true;
	private String temp = "";
	private Stack<Double> stos = new Stack<>();// zmienna stos typu Stack (ang. Stos)

	public oblicz(String wyrazenie) {
		this.rozklad(wyrazenie);
	}

	private void rozklad(String wyrazenie) {
		StringTokenizer st = new StringTokenizer(wyrazenie, " ");// utw. obiektu typu StringTokenizer - rozbicie stringa
																	// na podstringi podzielone w tym przypadku znakiem
																	// " " (spacja)
		while (st.hasMoreElements() && czujnik) {// wykonuje się póki są jakieś elementy w wyrażeniu i poprzednie
													// elementy był operatorami lub double
			temp = st.nextToken();// do zmiennej temp zapisuje string z kolejnym elementem wyrażenia ucinając,
									// jednocześnie wycinając ten element z wyrazenia
			if (czyDouble(temp)) {// sprawdza czy element wyrażenia jest typu double
				stos.push(Double.valueOf(temp)); // zapisuje na stosie wartosc zmiennej
			} else if (czyOperator(temp) && stos.size() > 1) { // sprawdza czy element wyrażenie jest operatorem
				operacja(temp);// wywoluje funkcje operacja z parametrem - operatorem
			} else {
				czujnik = false; // false jeśli podano "nie operaor" lub "nie double"
			}
		}
		if (czujnik && stos.size() == 1) {// jesli wszystkie elementy podanego wyrazenia są poprawne i na stosie została
											// 1 zmienna to wynik jest tą ostatnią zmienną zapisaną na stosie
			wynik = stos.pop();// zdjęcie wyniku ze stosu i zapisanie go w zmiennej wynik
			System.out.println("Wynik : " + wynik);
		} else
			System.out.println("Wprowadzono złe wyrażenie");
	}

	private boolean czyDouble(String s) {
		try {
			Double.parseDouble(s);// przekształcanie stringa w double
		} catch (NumberFormatException e) {
			return false;// jeśli format liczby sie nie zgadza zwroc false
		} catch (NullPointerException e) {
			return false;// jesli wystapi błąd wskaznika zwroc false
		} // w innym przypadku zwroc true czyli element wyrazenia jest typu double
		return true;
	}

	private boolean czyOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) // jezeli element wyrazenie jest jednym ze
																				// znakow zwroc true
			return true;
		else
			return false;
	}

	private void operacja(String s) {
		double tmp1, tmp2, wynik;
		switch (s) {
		case ("+"):// jezeli elementem wyrazenia jest znak + to wez ze stosu 2 szczytowe elementy,
					// dodaj je do siebie a wynik zapisz na sosie
			tmp1 = stos.pop();
			tmp2 = stos.pop();
			wynik = tmp2 + tmp1;
			stos.push(wynik);
			System.out.println(tmp2 + "+" + tmp1 + "=" + wynik);
			// stos.push(stos.pop() + stos.pop());
			break;
		case ("-"):
			tmp1 = stos.pop();
			tmp2 = stos.pop();
			wynik = tmp2 - tmp1;
			stos.push(wynik);
			System.out.println(tmp2 + "-" + tmp1 + "=" + wynik);
			// stos.push(-stos.pop() + stos.pop());
			break;
		case ("*"):
			tmp1 = stos.pop();
			tmp2 = stos.pop();
			wynik = tmp2 * tmp1;
			stos.push(wynik);
			System.out.println(tmp2 + "*" + tmp1 + "=" + wynik);
			// stos.push(stos.pop() * stos.pop());
			break;
		case ("/"):
			tmp1 = stos.pop();
			tmp2 = stos.pop();
			wynik = tmp2 / tmp1;
			stos.push(wynik);
			System.out.println(tmp2 + "/" + tmp1 + "=" + wynik);
			// stos.push((1 / stos.pop()) * stos.pop());
			break;
		}
	}
}
