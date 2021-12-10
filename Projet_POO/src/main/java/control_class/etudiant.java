/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control_class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class etudiant extends personne{
    private String nom;
    private String prenom;
    private int groupe;
    private String ncin;
    
    
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

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
    
    public etudiant(String nom, String prenom, int groupe, String ncin, String username, String password) {
        super(username, password);
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
    
    public Boolean connxion(){
        Boolean existe=false;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select * from etudiant where username='"+getUsername()+"' and password='"+getPassword()+"'");
            if (rs.next()){
                existe=true;
            }else{
                JOptionPane.showMessageDialog(null,"connection invalide");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
        return existe;
    }
    
    public void connecter(){
        try {
                String url="jdbc:mysql://localhost:3306/projet_poo";
                con = DriverManager.getConnection(url,"rayen","rayen");
                st = con.createStatement();
                st.executeUpdate("update etudiant set connexion=1 where username='"+getUsername()+"' and password='"+getPassword()+"'");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
    public void ajouter(){
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            pst = con.prepareStatement("insert into etudiant (`nom`,`prenom`,`username`, `password`,`groupe`,`ncin`) values(?,?,?,?,?,?)");
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setString(3, getUsername());
            pst.setString(4, getPassword());
            pst.setInt(5, groupe);
            pst.setString(6, ncin);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "ajout fait avec success");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erreur !");
        }
    }
    
    public Boolean existe(){
        Boolean test=false;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select * from etudiant where username='"+getUsername()+"'");
            if (rs.next()){
                test=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
        return test;
    }
    
    public int quiConnecter(){
        int id=-1;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select id_e from etudiant where connexion = 1");
            rs.next();
            id = rs.getInt(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
        return id;
    }
    
    public void deconnexion(){
        try {
                String url="jdbc:mysql://localhost:3306/projet_poo";
                con = DriverManager.getConnection(url,"rayen","rayen");
                st = con.createStatement();
                st.executeUpdate("update etudiant set connexion=0 where id_e="+getId());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
    public void getToutInfoEtudiant(){
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select * from etudiant where id_e="+getId());
            rs.next();
            setUsername(rs.getString("username"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
    }
    
}
