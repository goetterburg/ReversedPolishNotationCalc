import java.util.Stack;
import java.lang.*;

public class oblicz {
	private int licznik = 0;
	//private String wyrazenie;
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
			System.out.println(temp);
			if (czyDouble(temp)) {
				stos.push(Double.valueOf(temp));
				wyrazenie = wyrazenie.substring(index + 1, wyrazenie.length());
				licznik++;
				index = wyrazenie.indexOf(" ");
			} else if (czyOperator(temp) && stos.size() > 1) {
				operacja(temp);
				System.out.println(temp);
			} else {
				System.out.println(temp);
				index=-1;
			}

		}
		{
			wynik=stos.pop();
		}
		if (index == -1 && licznik==0) {
			System.out.println("Złe wyrażenie");
		}else if(index==-1&&licznik!=0)
		{
			System.out.println("Wynik : "+wynik);
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
		if (s == "+" || s == "-" || s == "*" || s == "/")
			return true;
		else
			return false;
	}

	private void operacja(String s) {
		switch (temp) {
		case ("+"):
			stos.push(stos.pop() + stos.pop());
			//licznik--;
			break;
		case ("-"):
			stos.push(-stos.pop() + stos.pop());
			//licznik--;
			break;
		case ("*"):
			stos.push(stos.pop() * stos.pop());
			//licznik--;
			break;
		case ("/"):
			stos.push((1 / stos.pop()) * stos.pop());
			//licznik--;
			break;
		}
	}
}
