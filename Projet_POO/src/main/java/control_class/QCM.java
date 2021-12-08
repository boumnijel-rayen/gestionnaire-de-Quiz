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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class QCM {
    private int num_qe;
    private String text;
    private int qcmA;
    private ArrayList<option> options;
    
    
    
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    
    public QCM(){
        num_qe = 0;
        text = "";
        qcmA=0;
        options = new ArrayList<option>();
    }

    public QCM(int num_qe, String text,int qcmA) {
        this.num_qe = num_qe;
        this.text = text;
        this.qcmA = qcmA;
        this.options = new ArrayList<option>();
    }
    
    public QCM(String text) {
        this.text = text;
        this.options = new ArrayList<option>();
    }

    public int getNum_qe() {
        return num_qe;
    }

    public void setNum_qe(int num_qe) {
        this.num_qe = num_qe;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<option> options) {
        this.options = options;
    }
    
    public void ajouterQcm(int num_Q){
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            pst = con.prepareStatement("insert into qcm (`text`, `num_q`) values(?,?)");
            pst.setString(1, text);
            pst.setInt(2, num_Q);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erreur !");
        }
    }
    
    public int quiAjoute(){
        int num=-1;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select num_qe from qcm where qcmA = 1");
            rs.next();
            num = rs.getInt(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
        return num;
    }
    
    public void metAZero(){
        try {
                String url="jdbc:mysql://localhost:3306/projet_poo";
                con = DriverManager.getConnection(url,"rayen","rayen");
                st = con.createStatement();
                st.executeUpdate("update qcm set qcmA=0");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
    public void metAUn(){
        try {
                String url="jdbc:mysql://localhost:3306/projet_poo";
                con = DriverManager.getConnection(url,"rayen","rayen");
                st = con.createStatement();
                st.executeUpdate("update qcm set qcmA=1 where num_qe="+num_qe);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
    public void afficherOptions(){
        Boolean rep;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select * from `projet_poo`.`option` where num_qe="+num_qe);
            while(rs.next()){
                if (rs.getInt("rep") == 1)
                    rep = true;
                else
                    rep=false;
                option o = new option(rs.getInt("num_o"),rs.getString("text"),rep);
                options.add(o);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
    }
    
    public void modifierQcm(){
        try {
                String url="jdbc:mysql://localhost:3306/projet_poo";
                con = DriverManager.getConnection(url,"rayen","rayen");
                st = con.createStatement();
                st.executeUpdate("update qcm set text='"+text+"' where num_qe="+num_qe);
                JOptionPane.showMessageDialog(null, "modification fait avec success");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
}
