/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control_class;

/**
 *
 * @author asus
 */
public class etudiant extends personne{
    private String nom;
    private String prenom;
    private int groupe;
    private String ncin;

    public etudiant() {
        super();
        nom = "";
        prenom = "";
        groupe = 0;
        ncin = "";
    }

    public etudiant(String nom, String prenom, int groupe, String ncin, int id, String username, String password, int cox) {
        super(id, username, password, cox);
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
        this.ncin = ncin;
    }
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public String getNcin() {
        return ncin;
    }

    public void setNcin(String ncin) {
        this.ncin = ncin;
    }
    
    
    
}
