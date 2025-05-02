package fr.esic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fr.esic.library.MyLibrary;
import fr.esic.model.Compte;
import fr.esic.model.Person;



public class OperationCompte {
		public static List<Compte> listCompte = new ArrayList<Compte>();
		
		public static void createCompte() {
			String numCompte = generateNumCompte();
			double solde = MyLibrary.saisieDouble("Saisissez le solde : ");
			
			int choix = MyLibrary.saisieEntier("1- Choisir le client" + "\n2- Créer un nouveau client");
			Person p = null;
			if (choix == 1) {
				p = OperationPerson.getClientByEmail(MyLibrary.saisie("Saisissez l'email du client : "));
			} else {
				 p = OperationPerson.createClient();
			}
			
			Compte c = new Compte(p, solde, numCompte );
			listCompte.add(c);
		
		}
		
		private static String generateNumCompte() {
			String numCompte = "";
			String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			for (int i = 0; i < 8; i++) {
				numCompte += alphabet.charAt((int) (Math.random() * alphabet.length()));
			}
			return numCompte.toUpperCase();
		}
		public static Compte getCompteByNum() {
			Compte c = null;
			String numCompte = MyLibrary.saisie("Saisissez le numéro de compte : ");
			
			for (Compte compte : listCompte) {
				if (compte.getNumeroCompte().equals(numCompte)) {
					c = compte;
				}
			}
			return c;
		}
		public static void depotByConseiller() {
			Compte c = getCompteByNum();
			if (c != null) {
				double montant = MyLibrary.saisieDouble("Saisissez le montant à déposer : ");
				c.depot(montant);
			}else {
				MyLibrary.afficher("Compte introuvable");
			}
		}
		public static void virementByConseiller() {
			Compte c = getCompteByNum();
			if (c != null) {
				double montant = MyLibrary.saisieDouble("Saisissez le montant à virer");
				c.virement(c,montant);
			}
		}
		public static Compte RechercherCompte(String numeroCompte) {
			Compte co = null;
			for(Compte c : listCompte) {
				if (co.getNumeroCompte().equals(numeroCompte)) {
					co = c;
				}
				}
			return co;
		}
		public static void listCompte() {
			String data = "";
			for (Compte c : listCompte) {
					data += c.infoCompte() + "\n";
				}
			if (data.equals("")) {
				MyLibrary.afficher("Aucun compte trouvé");
			} else {
				MyLibrary.afficher(data);
			}
		}
public static void deleteCompte() {
	Compte c = getCompteByNum();
	if (c != null) {
		listCompte.remove(c);
		MyLibrary.afficher("Compte supprimé");
	}else {
	MyLibrary.afficher("Compte non trouvé");
}
}

public static void modifieCompte() {
	Compte c = getCompteByNum();
	boolean value = true;
	if(c == null) {
		MyLibrary.afficher("Compte introuvable");
	}else {
		while(value) {
		int choix = MyLibrary.saisieEntier("Choisissez ce que vous voulez modifier :"+ "\n1- Titulaire \n2- Solde \n3- Quittez");
		switch (choix) {
		case 1:
			Person titulaire = OperationPerson.getClientByEmail(MyLibrary.saisie("Veuillez saisir le nouvel email"));
			c.setTitulaire(titulaire);
			MyLibrary.afficher("Modification effectuée");
			break;
		case 2:
			int solde = MyLibrary.saisieEntier("Veuillez saisir le nouveau solde");
			c.setSolde(solde);
			MyLibrary.afficher(null);
			break;
		case 3:
			value = false;
			MyLibrary.afficher("Repassez modifier quand vous le souhaitez");
			break;
 
		default:
			MyLibrary.afficher("Une erreur s'est produite, veuillez recommencer ");
			break;
		}
		}
	}
}}
 

	

