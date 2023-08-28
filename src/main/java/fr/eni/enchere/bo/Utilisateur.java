package fr.eni.enchere.bo;

public class Utilisateur {
	private Integer noUtilisateur;
	private String pseudo;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motdepasse;
	private Integer credit;
	private Boolean administateur;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String pseudo, String prenom, String email, String telephone, String rue, String codePostal,
			String ville, String motdepasse, Integer credit, Boolean administateur) {
		super();
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motdepasse = motdepasse;
		this.credit = credit;
		this.administateur = administateur;
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
	public Boolean getAdministateur() {
		return administateur;
	}
	public void setAdministateur(Boolean administateur) {
		this.administateur = administateur;
	}
	
	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", prenom=" + prenom + ", email="
				+ email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
				+ ville + ", motdepasse=" + motdepasse + ", credit=" + credit + ", administateur=" + administateur
				+ "]";
	}
	
	
}
