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
public class enseignant extends personne{
    
    private ArrayList<Quiz> quizs;

    public enseignant() {
        super();
        quizs = new ArrayList<Quiz>();
    }

    public enseignant(int id, String username, String password, int cox) {
        super(id, username, password, cox);
        this.quizs = new ArrayList<Quiz>();
    }

    public ArrayList<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(ArrayList<Quiz> quizs) {
        this.quizs = quizs;
    }
    
    
    
    
    
}
