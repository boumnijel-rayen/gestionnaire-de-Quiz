/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control_class;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Quiz {
    private int num_q;
    private String theme;
    private ArrayList<QCM> QCMs;
    
    
    public Quiz(){
        num_q = 0;
        theme = "";
        QCMs = new ArrayList<QCM>();
    }

    public Quiz(int num_q, String theme) {
        this.num_q = num_q;
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

    public ArrayList<QCM> getQCMs() {
        return QCMs;
    }

    public void setQCMs(ArrayList<QCM> QCMs) {
        this.QCMs = QCMs;
    }

    
}
