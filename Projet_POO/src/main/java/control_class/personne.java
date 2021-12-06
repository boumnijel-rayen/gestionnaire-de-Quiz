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
 public abstract class personne {
    private int id;
    private String username;
    private String password;
    private int cox;
    
    public personne() {
        id = 0;
        username = "";
        password = "";
        cox = 0;
    }

    public personne(int id, String username, String password, int cox) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cox = cox;
    }
    
    public personne(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCox() {
        return cox;
    }

    public void setCox(int cox) {
        this.cox = cox;
    }
    
    public abstract Boolean connxion();
    public abstract void connecter();
    public abstract void ajouter();
    public abstract Boolean existe();
    
}
