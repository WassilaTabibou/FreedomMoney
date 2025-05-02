package fr.esic.model;

public class Compte {
	private Person titulaire;
	private double solde;
	private String numeroCompte;
	
	public Compte() {
	}
	
	public Compte(Person titulaire, double solde, String numeroCompte) {
		this.titulaire = titulaire;
		this.solde = solde;
		this.numeroCompte = numeroCompte;
	}

	public Person getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(Person titulaire) {
		this.titulaire = titulaire;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	public String infoCompte() {
		return "Numero: " + numeroCompte + ", Solde: " + solde 
				+ ", Titulaire: " + titulaire.infoPerson();
	}
	public boolean depot(double montant) {
		if(montant>0) {
			solde += montant;
			return true;
		}else {
			return false;
			
		}
	}
	public boolean retrait(double montant) {
		if(montant > 0 && montant<= solde) {
			solde -= montant;
			return true;
		}else {
			return false;
		}
	}
	public boolean virement(Compte compte, double montant) {
		if (retrait(montant)) {
			compte.depot(montant);
			return true;
		}else {
			return false;
		}
	}
}

