package fr.esic.controller;

import fr.esic.model.Compte;
import fr.esic.model.Person;
import fr.esic.model.Role;

public class Data {
public static void initData() {
	Role r1 = new Role(1,"Admin".toUpperCase());
	Role r2 = new Role(2,"Client".toUpperCase());
	Role r3 = new Role(3,"Conseiller".toUpperCase());
	OperationRole.listRole.add(r1);
	OperationRole.listRole.add(r2);
	OperationRole.listRole.add(r3);
	
	Person p1 = new Person("a", "b", "ab@gmail.com", "hbi", r1);
	Person p2 = new Person("l", "m", "lm@yahoo.fr", "hbi", r2);
	Person p3 = new Person("z", "r", "zr@yahoo.fr", "hbi", r3);
	Person p4 = new Person("w", "tbu", "wtbu@gmail.com", "hbi", r3);
	Person p5 = new Person("a", "ysf", "aysf@gmail.com", "hbi", r1);
	
	Compte c1 = new Compte(p1,1000, "c1001");
	Compte c2 = new Compte(p2,2000, "c1002");
	Compte c3 = new Compte(p3,3000, "c1003");
	Compte c4 = new Compte(p4,4000, "c1004");
	Compte c5 = new Compte(p5,5000, "c1005");
	Compte c6 = new Compte(p1,6000, "c1006");
	
	OperationPerson.listPerson.add(p1);
	OperationPerson.listPerson.add(p2);
	OperationPerson.listPerson.add(p3);
	OperationPerson.listPerson.add(p4);
	OperationPerson.listPerson.add(p5);
	
	OperationCompte.listCompte.add(c1);
	OperationCompte.listCompte.add(c2);
	OperationCompte.listCompte.add(c3);
	OperationCompte.listCompte.add(c4);
	OperationCompte.listCompte.add(c5);
	OperationCompte.listCompte.add(c6);
	
	

	
}
}
