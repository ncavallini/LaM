//package lam; Uncomment this line and change the package name according to your settings. If you are executing this online, leave this line commented.

import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {

        System.out.print("Questo programma cifra un messaggio con il cifrario di Vernam data una chiave. \n \n");

        Scanner input = new Scanner(System.in);

        System.out.println("Inserire la parola da cifrare.");

        String messaggio = input.next().toUpperCase(); // Uso solo le maiuscole per semplicita'.

        System.out.println("Inserire la chiave.");

        String chiave = input.next();

        if (chiave.length() < messaggio.length()) {
            System.out.println("Chiave non valida. La lunghezza della chiave e' minore di quella del messaggio.");
            System.exit(0);
        } else {
            chiave = chiave.toUpperCase(); // Uso solo le maiuscole per semplicita'.
        }
        input.close();

        int[] intmessaggio = new int[messaggio.length()];
        int[] intchiave = new int[chiave.length()];

        for (int i = 0; i < messaggio.length(); i++) {
            intmessaggio[i] = (int) messaggio.charAt(i) - 64;
        }

        for (int i = 0; i < chiave.length(); i++) {
            intchiave[i] = (int) chiave.charAt(i) - 64;
        }

        int[] intcifrato = new int[messaggio.length()];

        String cifrato = "";

        for (int i = 0; i < messaggio.length(); i++) {
            intcifrato[i] = ((intmessaggio[i] + intchiave[i]) % 26) + 63;
            cifrato += (char) intcifrato[i];
        }

        System.out.println("MESSAGGIO CIFRATO: " + cifrato);

    }

}
