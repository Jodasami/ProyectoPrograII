/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.UserData;
import Domain.User;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fabio
 */
public class UserBusiness {

    UserData userData;

    public UserBusiness() {
        userData = new UserData();
    }

    public String insertUser(User user) throws IOException, ParseException, java.text.ParseException {

        String success = "";

        //ToDo regla de negocio
        if (userData.getUser(user.getUsername()).getUsername() == null) {

            userData.insertUser(user);

            success = "yes";

        }

        return success;

    }

    public LinkedList<User> getAllUsers() throws ParseException, java.text.ParseException, IOException {
        return userData.getAllUsers();
    }

    public User getUser(String username, String password) throws ParseException, IOException, java.text.ParseException {

        return userData.getUser(username, password);
    }
    
    public User getUser(String username) throws ParseException, IOException, java.text.ParseException {

        return userData.getUser(username);
    }
    
     public void modifyUser(String userName, User user) throws IOException, ParseException, java.text.ParseException {

        userData.modifyUserFromFile(userName, user);

    }

    public void deleteUser(String userUsername) throws IOException, ParseException, java.text.ParseException {

        userData.deleteUser(userUsername);

    }
    
    public void setCurrentLoggedUser(String username){
       userData.setCurrentLoggedUser(username);
    }

     public String getCurrentLoggedUser(){
        return userData.getCurrentLoggedUser();
    }
}
