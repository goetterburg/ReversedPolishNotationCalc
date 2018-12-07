import java.util.Stack;
import java.lang.*;

public class oblicz {
	private int licznik = 0;
	// private String wyrazenie;
	double wynik = 0;
	int index;
	String temp = "";
	Stack<Double> stos = new Stack<>();

	public oblicz(String wyrazenie) {
		this.rozklad(wyrazenie);
	}

	private void rozklad(String wyrazenie) {
		index = wyrazenie.indexOf(" ");
		while (index != -1) {
			temp = wyrazenie.substring(0, index);
			// index = wyrazenie.indexOf(" ");
			// System.out.println("wczytałem znak: "+temp);
			if (czyDouble(temp)) {
				stos.push(Double.valueOf(temp));
				wyrazenie = wyrazenie.substring(index + 1, wyrazenie.length());
				licznik++;
				System.out.println("spacja na poz: " + index);
			} else if (czyOperator(temp) && stos.size() > 1) {
				System.out.println("czy operator" + temp);
				operacja(temp);
			} else {
				System.out.println("else" + temp);
				index = -1;
			}
			System.out.println("poza ifami " + temp + " wielk. stosu: " + stos.size());
		}
		if (index == -1 && licznik > 1) {
			System.out.println("else if");
			wynik = stos.pop();
			System.out.println("licznik:" + licznik + "Wynikiiii : " + wynik);
		} else{
			System.out.println("Złe wyrażenie");
		}
	}

	private boolean czyDouble(String s) {
		try {
			Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	private boolean czyOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		else
			return false;
	}

	private void operacja(String s) {
		switch (s) {
		case ("+"):
			System.out.println("dodaje");
			stos.push(stos.pop() + stos.pop());
			System.out.println("peek" + stos.peek());
			// licznik--;
			break;
		case ("-"):
			System.out.println("odejmuje");
			stos.push(stos.pop() - stos.pop());
			System.out.println("peek" + stos.peek());
			// licznik--;
			break;
		case ("*"):
			System.out.println("mnożę");
			stos.push(stos.pop() * stos.pop());
			System.out.println("peek" + stos.peek());
			// licznik--;
			break;
		case ("/"):
			System.out.println("dziele");
			stos.push(stos.pop() / stos.pop());
			System.out.println("peek" + stos.peek());
			// licznik--;
			break;
		}
	}
}
