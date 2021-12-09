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
public class option {
    private int num_o;
    private String text;
    private Boolean rep;
    
    
    
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    
    public option(){
        num_o = 0;
        text = "";
        rep = null;
    }

    public option(int num_o, String text, Boolean rep) {
        this.num_o = num_o;
        this.text = text;
        this.rep = rep;
    }
    
    public option(String text, Boolean rep) {
        this.text = text;
        this.rep = rep;
    }

    public int getNum_o() {
        return num_o;
    }

    public void setNum_o(int num_o) {
        this.num_o = num_o;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRep() {
        return rep;
    }

    public void setRep(Boolean rep) {
        this.rep = rep;
    }
    
    public void ajouterOption(int num_qe){
        int repA = 0;
        if (rep == true)
            repA=1;      
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            pst = con.prepareStatement("INSERT INTO `projet_poo`.`option` (`text`, `rep`, `num_qe`) VALUES (?,?,?)");
            pst.setString(1, text);
            pst.setInt(2, repA);
            pst.setInt(3, num_qe);           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erreur !");
        }
    }
    
    public void modifierOption(){
        int R;
        if (rep==true)
            R=1;
        else
            R=0;
        try {
                String url="jdbc:mysql://localhost:3306/projet_poo";
                con = DriverManager.getConnection(url,"rayen","rayen");
                st = con.createStatement();
                st.executeUpdate("update `projet_poo`.`option` set text='"+text+"',rep="+rep+" where num_o="+num_o);
                JOptionPane.showMessageDialog(null, "modification fait avec success");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
    public void repOptions(){
        int r;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select * from `projet_poo`.`option` where num_o="+num_o);
            rs.next();
            r = rs.getInt("rep");   
            if (r==1){
                rep=true;
            }else{
                rep=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }      
    }
    
    
}
