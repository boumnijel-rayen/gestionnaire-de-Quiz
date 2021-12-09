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
public class reponse {
    private etudiant e;
    private Quiz q;
    private int score;
    
    
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    
    public reponse() {
        e = new etudiant();
        q = new Quiz();
        score = 0;
    }
    
    public reponse(int score) {
        this.e = new etudiant();
        this.q = new Quiz();
        this.score = score;
    }

    public etudiant getE() {
        return e;
    }

    public void setE(etudiant e) {
        this.e = e;
    }

    public Quiz getQ() {
        return q;
    }

    public void setQ(Quiz q) {
        this.q = q;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public ArrayList<reponse> chargerReponse(int id){
        ArrayList<reponse> R = new ArrayList<reponse>();
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select * from repondre where id_e="+id);
            while(rs.next()){
                reponse r = new reponse();
                r.getE().setId(rs.getInt("id_e"));
                r.getQ().setNum_q(rs.getInt("num_q"));
                r.setScore(rs.getInt("score"));
                R.add(r);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erreur !");
        }
        return R;
    }
    public void enregistrerRep(){
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            pst = con.prepareStatement("INSERT INTO `projet_poo`.`repondre` (`id_e`, `num_q`, `score`) VALUES (?,?,?)");
            pst.setInt(1, e.getId());
            pst.setInt(2, q.getNum_q());
            pst.setInt(3, score);           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erreur !");
        }
    }
    
}
