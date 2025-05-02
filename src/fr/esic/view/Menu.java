package fr.esic.view;

import javax.swing.JOptionPane;

import fr.esic.controller.OperationCompte;
import fr.esic.controller.OperationPerson;
import fr.esic.library.MyLibrary;
import fr.esic.model.Compte;
import fr.esic.model.Person;

public class Menu {
	public static void menuAdmin() {
		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary.saisieEntier("1- Créer un Admin" + "\n2- Créer un conseiller"
					+ "\n3- Lister les utilisateurs\n4- Modifier un utilisateur"
					+ "\n5- Supprimer un utilisateur\n6- Quitter");
			switch (choix) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				continuer = false;
				break;
			default:
				break;
			}
		}
	}

	public static void menuClient() {

	}

	public static void menuConseiller() {
		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary.saisieEntier("1- Créer un nouveau client "
					+ "\n2- Créer un compte\n3- Lister les comptes" + "\n4- Supprimer un compte"
					+ "\n5- Modifier un compte" + "\n6- Rechercher un compte\n7- Faire un depot "
					+ "\n8- Faire un virement\n9- Tous les Client \n10- Se déconnecter");

			switch (choix) {
			case 1:
				OperationPerson.createClient();
				break;
			case 2:
				OperationCompte.createCompte();
				break;
			case 3:
				OperationCompte.listCompte();
				break;
			case 4:
				//OperationCompte.deleteCompte();
				break;
			case 5:
				OperationCompte.modifieCompte();
				break;
			case 6:
				OperationCompte.RechercherCompte(null);
				break;
			case 7:
				OperationCompte.depotByConseiller();
				break;
			case 8:
				OperationCompte.virementByConseiller();
				break;
			case 9:
				OperationPerson.listClient();
				break;
			case 10:
				continuer = false;
				Menu.afterLogout();
				break;
			default:
				break;
			}
		}
	}

	public static void afterLogout() {
		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary.saisieEntier("1- Se connecter\n2-Quitter");
			switch (choix) {
			case 1:
				continuer = false;
				demarrage();
				break;
			case 2:
				System.out.println("Merci de votre visite, à bientôt !");
				continuer = false;
				break;
			default:
				break;
			}
		}
	}

	public static void demarrage() {
		Person person = OperationPerson.connexion();
		int compteur = 0;
		while (person == null && compteur < 3) {
			MyLibrary.afficher("Email ou mot de passe incorrect");
			person = OperationPerson.connexion();
			compteur++;
		}
		if (compteur == 3 && person == null) {
			MyLibrary.afficher("Vous avez atteint le nombre maximum de tentatives de connexion");
			return;
		} else {
			switch (person.getRole().getNomRole()) {
			case "ADMIN":
				menuAdmin();
				break;
			case "CONSEILLER":
				menuConseiller();
				break;
			case "CLIENT":
				menuClient();
				break;

			default:
				break;

			}
		}
	}
}
