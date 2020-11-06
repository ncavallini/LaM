package lam;

import java.util.Scanner;

public class Cifrario_Cesare {

	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
	
	String plaintext = "";
	String criptato = "";
	int k =0; // chiave
	System.out.println("Inserire una chiave [numero intero fra 1 e 26]");
	
try {

k = input.nextInt();
 

}
catch(Exception e)  {
	System.out.println("La chiave inserita non è un numero intero. Riprovare. PROGRAMMA TERMINATO.");
	System.exit(-1);
}

finally {}

if( k < 0 || k> 26) {
	System.out.println("La chiave è minore di 0 o maggiore di 26. Riprovare. PROGRAMMA TERMINATO.");
	System.exit(-1);
}
else {
	System.out.println("Inserire un messaggio da criptare (gli spazi non contano)");
	plaintext =  input.next().toUpperCase(); // uso solo lettere maiuscole per semplificare.

	
	int [] plainarray = new int[plaintext.length()];
	int [] arraycriptato = new int [plaintext.length()];
	
for(int i =0; i < plaintext.length(); i++)	{
	plainarray[i] = (int) plaintext.charAt(i);
}
		
	for(int i=0 ; i < plaintext.length(); i++){
		
		arraycriptato[i] = (plainarray[i] + k);   
		if(arraycriptato[i] > 90) {
			arraycriptato[i] -= 26;
		}
		criptato += (char) arraycriptato[i];
		
	}
		System.out.println("MESSAGGIO CRIPTATO: " + criptato + "\t [chiave " + k + "]");
		input.close();
}

	}
	
}



