package fr.esic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fr.esic.library.MyLibrary;
import fr.esic.model.Person;
import fr.esic.model.Role;

public class OperationPerson {
	public static List<Person> listPerson = new ArrayList<Person>();

	public static Person connexion() {
		Person person = null;
		String email = MyLibrary.saisie("Saissisez votre email : ");
		String password = MyLibrary.saisie("Saissisez votre mot de passe : ");
		for (Person p : listPerson) {
			if (p.getEmail().equals(email) && p.getPassword().equals(password)) {
				person = p;
			}
		}

		return person;
	}
	
	public static Person createClient() {
		String nom = MyLibrary.saisie("Saisissez le nom : ");
        String prenom = MyLibrary.saisie("Saisissez le prenom : ");
        String email = MyLibrary.saisie("Saisissez l'email : ");
        String password = generatePassword();
        System.out.println("Le mot de passe de : " + email + "est : " + password);
       
        Role role = OperationRole.getRoleByRoleName("client".toUpperCase());
        
        Person p = new Person(nom, prenom, email, password, role);
        listPerson.add(p);
        return p;
    }
	
	private static String generatePassword() {
		String password = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123"
				+ "456789";
		for (int i = 0; i < 8; i++) {
			password += alphabet.charAt((int) (Math.random() * alphabet.length()));
		}
		return password;
	}
	
	public static void listClient() {
		String data = "";
		for (Person p : listPerson) {
			if (p.getRole().getNomRole().equals("CLIENT")) {
				data += p.infoPerson() + "\n";
			}
		}
		if (data.equals("")) {
			MyLibrary.afficher("Aucun client trouvé");
		} else {
			MyLibrary.afficher(data);
		}
	}
	
	public static Person getClientByEmail(String email) {
		Person person = null;
		for (Person p : listPerson) {
			if (p.getEmail().equals(email) && p.getRole().getNomRole().equals("CLIENT")) {
				person = p;
			}
		}
		return person;
	}
	
}

