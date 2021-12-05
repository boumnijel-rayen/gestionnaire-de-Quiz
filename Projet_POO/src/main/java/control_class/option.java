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
public class option {
    private int num_o;
    private String text;
    private Boolean rep;
    
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
    
    
    
}
