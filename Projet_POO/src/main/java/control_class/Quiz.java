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
public class Quiz {
    private int num_q;
    private String theme;
    private int quizM;
    private ArrayList<QCM> QCMs;
    
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    
    
    public Quiz(){
        num_q = 0;
        theme = "";
        quizM=0;
        QCMs = new ArrayList<QCM>();
    }

    public Quiz(int num_q, String theme,int quizM) {
        this.num_q = num_q;
        this.theme = theme;
        this.quizM = quizM;
        this.QCMs = new ArrayList<QCM>();
    }
    
    public Quiz(String theme) {
        this.theme = theme;
        this.QCMs = new ArrayList<QCM>();
    }

    public int getNum_q() {
        return num_q;
    }

    public void setNum_q(int num_q) {
        this.num_q = num_q;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getQuizM() {
        return quizM;
    }

    public void setQuizM(int quizM) {
        this.quizM = quizM;
    }
    
    public ArrayList<QCM> getQCMs() {
        return QCMs;
    }

    public void setQCMs(ArrayList<QCM> QCMs) {
        this.QCMs = QCMs;
    }

    public void ajouterQuiz(int id_en){
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            pst = con.prepareStatement("insert into Quiz (`theme`, `id_en`) values(?,?)");
            pst.setString(1, theme);
            pst.setInt(2, id_en);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Quiz a été ajouté !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erreur !");
        }
    }
    
    public int quiModifier(){
        int num=-1;
        try {
            String url="jdbc:mysql://localhost:3306/projet_poo";
            con = DriverManager.getConnection(url,"rayen","rayen");
            st = con.createStatement();
            rs = st.executeQuery("select num_q from quiz where quizM = 1");
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
                st.executeUpdate("update quiz set quizM=0");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur !");
            }
    }
    
}
