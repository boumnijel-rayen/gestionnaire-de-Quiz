/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control_class;

import Interfaces.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class enseignant extends personne{
    
    private ArrayList<Quiz> quizs;
    
    
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    public enseignant() {
        super();
        quizs = new ArrayList<Quiz>();
    }

    public enseignant(int id, String username, String password, int cox) {
        super(id, username, password, cox);
        this.quizs = new ArrayList<Quiz>();
    }
    
    public enseignant(String username, String password) {
        super(username, password);
        this.quizs = new ArrayList<Quiz>();
    }

    public ArrayList<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(ArrayList<Quiz> quizs) {
        this.quizs = quizs;
    }
    
    public Boolean connxion(){
        Boolean existe=false;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select * from enseignant where username='"+getUsername()+"' and password='"+getPassword()+"'");
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
                st.executeUpdate("update enseignant set connexion=1 where username='"+getUsername()+"' and password='"+getPassword()+"'");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
    public void ajouter(){
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            pst = con.prepareStatement("insert into enseignant (`username`, `password`) values(?,?)");
            pst.setString(1, getUsername());
            pst.setString(2, getPassword());
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
            rs = st.executeQuery("select * from enseignant where username='"+getUsername()+"'");
            if (rs.next()){
                test=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
        return test;
    }
    
    
}
