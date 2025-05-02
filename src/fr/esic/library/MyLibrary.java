package fr.esic.library;

import javax.swing.JOptionPane;

public class MyLibrary {
	public static void main(String[] args) {
		String msg = saisie("Quel est votre nom ?");
		afficher("Bonjour " + msg);
		int entier = saisieEntier("Quel âge avez-vous");
		afficher("Vous avez "+ entier + " ans");
		double decimal = saisieDouble("Combien mesurez-vous ?") ;
		afficher("Vous mesurez "+ decimal + " cm");
		

	}
	public static void afficher(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	public static String saisie(String msg){
		return JOptionPane.showInputDialog(msg);
	}
	public static int saisieEntier(String entier) {
		return Integer.parseInt(saisie(entier));
	}
	public static double saisieDouble(String decimal) {
		return Double.parseDouble(saisie(decimal));
	}
	
}
