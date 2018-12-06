import java.util.*;

public class main {

    public static void main(String[] args) {

    	System.out.println("Podaj wyrażenie: ");
    	Scanner sc = new Scanner(System.in);
    	String wyrazenie=sc.nextLine();
    	System.out.println("Wprowadzono: "+wyrazenie);
    	oblicz obl = new oblicz(wyrazenie);
    	

    }
}