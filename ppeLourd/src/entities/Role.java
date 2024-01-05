package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the Roles database table.
 * 
 */
@Entity
@Table(name="Roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	private int idRole;

	private String libelle;

	private int permission;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="role")
	private List<Utilisateur> utilisateurs;
	
	public Role() {
	}

	public int getId() {
		return this.idRole;
	}

	public void setId(int id) {
		this.idRole = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPermission() {
		return this.permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> roles) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur role) {
		getUtilisateurs().add(role);
		role.setRole(this);

		return role;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setRole(null);

		return utilisateur;
	}
	

	public Role(int idRole, String libelle, int permission, List<Utilisateur> utilisateurs) {
		super();
		this.idRole = idRole;
		this.libelle = libelle;
		this.permission = permission;
		this.utilisateurs = utilisateurs;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", libelle=" + libelle + ", permission=" + permission + ", utilisateurs=" + utilisateurs + "]";
	}

}