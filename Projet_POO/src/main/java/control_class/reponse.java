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
public class reponse {
    private etudiant e;
    private Quiz q;
    private int score;
    
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
    
    
    
}
