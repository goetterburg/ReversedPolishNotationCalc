import java.util.Stack;

import java.util.StringTokenizer;

public class oblicz {
	private double wynik = 0;
	private boolean index = true;
	private String temp = "";
	private Stack<Double> stos = new Stack<>();

	public oblicz(String wyrazenie) {
		this.rozklad(wyrazenie);
	}

	private void rozklad(String wyrazenie) {
		StringTokenizer st = new StringTokenizer(wyrazenie, " ");
		while (st.hasMoreElements() && index) {
			temp = st.nextToken();
			if (czyDouble(temp)) {
				stos.push(Double.valueOf(temp));
			} else if (czyOperator(temp) && stos.size() > 1) {
				operacja(temp);
			} else {
				index = false;
			}
		}
		if (index && stos.size() == 1) {
			wynik = stos.pop();
			System.out.println("Wynik : " + wynik);
		} else
			System.out.println("Wprowadzono złe wyrażenie");
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
			stos.push(stos.pop() + stos.pop());
			break;
		case ("-"):
			stos.push(-stos.pop() + stos.pop());
			break;
		case ("*"):
			stos.push(stos.pop() * stos.pop());
			break;
		case ("/"):
			stos.push((1 / stos.pop()) * stos.pop());
			break;
		}
	}
}
