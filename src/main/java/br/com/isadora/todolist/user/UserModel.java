package br.com.isadora.todolist.user;

/*
 * Modelo com as informações dos usuários * 
 */
public class UserModel {
    
    private String username;
    private String name;
    private String password;

    /*
     * Getters e Setters 
     */
    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
