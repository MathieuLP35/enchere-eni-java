package fr.eni.enchere.bo;

import java.util.List;

public class Utilisateur {
	private Integer noUtilisateur;
	private String pseudo;
	private String prenom;
	private String nom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motdepasse;
	private Integer credit = 1000;
	private Boolean administrateur;
	
	private List<Enchere> listeEncheres;
	
	private Boolean isActive;
	

	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String pseudo, String prenom, String nom, String email, String telephone, String rue, String codePostal,
			String ville, String motdepasse, Integer credit, Boolean administrateur, Boolean isActive) {
		super();
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motdepasse = motdepasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.isActive = isActive;
	}
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Boolean getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	
	public void ajouterEnchere(Enchere e) {
		listeEncheres.add(e);
		e.setEncherisseur(this);
	}
	
	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}

	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", prenom=" + prenom + ", nom="
				+ nom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", motdepasse=" + motdepasse + ", credit=" + credit + ", administrateur="
				+ administrateur + ", listeEncheres=" + listeEncheres + ", isActive=" + isActive + "]";
	}

	
	
	
}
