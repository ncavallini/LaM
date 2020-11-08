package lam;
import java.security.SecureRandom;
public class DH {

	public static void main(String[] args) {
		// Algoritmo Diffie-Hellman
		
		// INIZIALIZZAZIONE VARIABILI
		
		int N = 0;
		int g = 0;
		int a = 0;
		int b = 0;
		int A = 0;
		int B = 0;
		int k = 0;
	    SecureRandom random = new SecureRandom();
		
		// Genero numero primo. Non è lungo quanto dovrebbe essere per non appesantire il programma. Questo è solo un test/esempio.
		
	    do {
	    	N = random.nextInt(30)+ 1;
	    } while(isPrime(N) == false || N==1 || N == 2);
		

	    System.out.println("Il numero N generato è N = " + N);
	    
	    
	    // "Genero" un generatore g
	    
	    int[] g1 = {0};
	    int[] g2 = {1};
	    int[] g3 = {2};
	    int[] g5 = {2,3};
	    int[] g7 = {3,5};
	    int[] g11 = {2,6,7,8};
	    int[] g13 = {2,6,7,11};
	    int[] g17 = {3, 5, 6, 7, 10, 11, 12, 14};
	    int[] g19 = {2, 3, 10, 13, 14, 15};
	    int[] g23 = {5, 7, 10, 11, 14, 15, 17, 19, 20, 21};
	    int[] g29 = {2, 3, 8, 10, 11, 14, 15, 18, 19, 21, 26, 27};
	    
	    int[] arrayg = {};
	    
	    if(N==1) {
	     arrayg = g1;
	    }
	    else if(N==2) {
	    	arrayg = g2;
	    }
	    else if(N==3) {
	    	arrayg = g3;
	    }
	    
	    else if(N==5) {
	    	arrayg = g5;
	    }
	    
	    else if(N==7) {
	    	arrayg = g7;
	    }
	    
	    else if(N==11) {
	    	arrayg = g11;
	    }
	    
	    else if(N==13) {
	    	arrayg = g13;
	    }
	    
	    else if(N==17) {
	    	arrayg = g17;
	    	
	    }
	    
	    else if(N==19) {
	    	arrayg = g19;
	    }
	    
	    else if(N==23) {
	    	arrayg = g23;
	    }
	    
	    else if(N==29) {
	    	arrayg = g29;
	    }
	    
	    // Scelgo g a caso da arrayg
	    
	    int i = random.nextInt(arrayg.length);
	    
	    g = arrayg[i];
	    
	    System.out.println("Il generatore g scelto è g = " + g);
	    
	    // Scelgo 2 numeri a, b con a < N e b < N
	    
	    do {
	        a = random.nextInt(N);
		    b = random.nextInt(N);
		    
	    }while(a==b || a == 0 || b == 0);
	    
	
	    System.out.println("I numeri a, b scelti sono: a = " + a + " e b = " + b);
	    
	    // Calcolo A e B
	    
	    A = (int) Math.pow(g,a);
	    B = (int) Math.pow(g,b);
	    
	    System.out.println("I numeri A e B sono: A = " + A + " e B = " + B);
	    
	    // Calcolo k. Verifico che kA e kB siano uguali.
	    
	    int kA = (int) Math.pow(A,b) % N;
	    int kB = (int) Math.pow(B, a) % N;
	    
	    if(kA == kB  && kA == (int) Math.pow(g, a*b) % N) {
	    	k = kA;
	    	System.out.println("\n \n Il segreto k è k = " + k);
	    }
	    else {
    	System.out.println("SI È VERIFICATO UN ERRORE.");	
    	}
	    
	}
	
	public static boolean isPrime (int num) {
		if(num == 2) {
			return true;
		}
			 if(num % 2 == 0) {
				return false;
			}
			 int rq = (int) Math.sqrt(num) +1;
			 
			 for(int i = 3 ; i < rq ; i = i+2) {
				 if(num % i == 0) {
					 return false;
				 }
				
			 }
			 return true;
		}
	

}
