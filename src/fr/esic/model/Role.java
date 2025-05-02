package fr.esic.model;

public class Role {
	private int idRole;
	private String nomRole;
	
	// Constructor vide
	public Role() {
	}
	
	// Constructor avec parametres
	public Role(int idRole, String nomRole) {
		this.idRole = idRole;
		this.nomRole = nomRole;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	
	public String infoRole() {
		return "ID: " + idRole + ", Role: " + nomRole;
	}
	
    
}
