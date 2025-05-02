package fr.esic.controller;

import java.util.ArrayList;
import java.util.List;

import fr.esic.model.Role;

public class OperationRole {
	public static List<Role> listRole = new ArrayList<Role>();
	
	
	public static Role getRoleByRoleName(String roleName) {
		Role role = null;
		for (Role r : listRole) {
			if (r.getNomRole().equals(roleName)) {
				role = r;
			}
		}
		return role;
	}
}
