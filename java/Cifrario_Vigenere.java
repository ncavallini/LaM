package lam;

import java.util.Scanner;

public class Cifrario_Vigenere {

	public static void main(String[] args) {
		
		
	//Cifrario di Vigenère secondo l'alfabeto inglese di 26 lettere.
		
		String chiave = "";
		String plaintext = "";
		Scanner input = new Scanner(System.in);
		

		
		System.out.println("CIFRARIO DI VIGENÈRE SECONDO L'ALFABETO INGLESE");
		System.out.println("\n");
		System.out.println("Inserire il testo da cifrare.");
		
		plaintext = input.next().toUpperCase(); // Uso le maiuscole per semplicità
		
		System.out.println("Inserire una chiave");
		
		chiave = input.next().toUpperCase(); // Uso le maiuscole per semplicità
		
		if(chiave.length() < plaintext.length()) {
			int differenza = plaintext.length() - chiave.length();
			
			for(int i=0; i < differenza;i++) {
				
				chiave += chiave.charAt(i);
			}
			
			System.out.println("Siccome la lunghezza della chiave è minore di quella del testo in chiaro, la chiave viene iterata per ottenere: " + chiave);
			
		}

		input.close();
		
		int[] chiave_array = new int[chiave.length()];
		int[] plain_array = new int[plaintext.length()];
		
		// System.out.println(plaintext + "\t" + chiave);

		for(int i = 0 ; i < chiave.length() ; i++) {
			chiave_array[i] = (int) chiave.charAt(i);
		}
		
		for(int i=0 ; i < plaintext.length() ; i++) {
			plain_array[i] = (int) plaintext.charAt(i);
		}
		
		int[] cifrato_array = new int[plaintext.length()];
		
		String cifrato = "";
		
		for(int i=0; i<plaintext.length();i++) {
	
			cifrato_array[i] = (plain_array[i] + chiave_array[i]) % 26 + 65; // Lavoro mod 26 (alfabeto inglese) e aggiungo 65 perché il codice ASCII della "A" maiuscola è 65.
		
			cifrato += (char) cifrato_array[i];
		}
		
		System.out.println("\n \n TESTO CIFRATO: " + cifrato);
		
	}

}
