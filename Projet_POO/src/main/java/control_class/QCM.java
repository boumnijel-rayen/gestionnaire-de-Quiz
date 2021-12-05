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
public class QCM {
    private int num_qe;
    private String text;
    private ArrayList<option> options;
    
    public QCM(){
        num_qe = 0;
        text = "";
        options = new ArrayList<option>();
    }

    public QCM(int num_qe, String text) {
        this.num_qe = num_qe;
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
    
    
}
