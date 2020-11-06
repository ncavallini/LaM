package lam;

import java.util.Scanner;

public class Metodo_Hill {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int[][] cifrante = new int[2][2];
		System.out.println("Questo programma cripta una parola con il metodo di Hill data una matrice di ordine 2. \n \n ");
		System.out.println("Inserire nell'ordine (riga per riga) i 4 coefficienti della matrice cifrante");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		
		if(a*d-b*c != 1 && a*d-b*c != -1) {
			System.out.println("La matrice ha determinante diverso da +/- 1 e pertanto non è valida. PROGRAMMA TERMINATO");
			System.exit(0);
		}
		cifrante[0][0]=a;
		cifrante[0][1]=b;
		cifrante[1][0]=c;
		cifrante[1][1]=d;
		
		

		System.out.println("Inserire la parola da crittografare.");
		String messaggio = input.next().toUpperCase();
		
		
		if(messaggio.length() % 2 !=0) {
			System.out.println("La stringa ha un numero dispari di caratteri. PROGRAMMA TERMINATO");
		}
		
		input.close();
		
		String[] splitmessaggio;
		splitmessaggio = messaggio.split("(?<=\\G..)", -1); //Con questa regex divido il messaggio in stringhe di 2 caratteri.
		
		int x = 0, y =0;
		
		String cifrato = "";
		
		for(int i=0;i<splitmessaggio.length - 1;i++) {
			try {
				x = (int) splitmessaggio[i].charAt(0) - 64;
				y = (int) splitmessaggio[i].charAt(1) - 64;
				
			}
			catch(Exception ignore) {}
			
			
			// System.out.println("x = " + x + " y = " + y);
			
			int[][] f = new int[2][1];
			
			f[0][0] = Math.abs((cifrante[0][0]*x + cifrante[0][1]*y)) % 26 ;
			f[1][0] = Math.abs((cifrante[1][0]*x + cifrante[1][1]*y)) % 26 ;
			
			
			cifrato += (char) (f[0][0] + 64);
			cifrato += (char) (f[1][0] + 64);
			
			
			
		}
		
	System.out.println(" \n  \n MESSAGGIO CIFRATO: " + cifrato);
		
		
		
	
	}

}
