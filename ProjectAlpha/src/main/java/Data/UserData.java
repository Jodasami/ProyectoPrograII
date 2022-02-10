/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Domain.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Fabio
 */
public class UserData {

    private static String currentUsername;
    final String JSONFILEPATH = "C:\\Users\\jodas\\Desktop\\ProyectoGit\\ProyectoPrograII\\ProjectAlpha\\Users.json";
//     final String JSONFILEPATH = "C:\\Users\\Fabio\\Desktop\\Progra 2\\Laboratorios Esteban\\ProyectoPrograII\\ProjectAlpha\\Users.json";

    public void insertUser(User user)
            throws IOException {
        JSONObject userObject = new JSONObject();
        userObject.put("name", user.getName());
        userObject.put("id", user.getId());
        userObject.put("phone", user.getPhone());
        userObject.put("username", user.getUsername());
        userObject.put("password", user.getPassword());
        userObject.put("disabilityPresented", user.isDisabilityPresented());
        userObject.put("role", "customer");
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(JSONFILEPATH, true)) {
            file.write(userObject.toJSONString() + "\n");
        }

        //Input and Output operations: Happens when there is a failure during reading, writing, and searching file or directory operations.
        //Throws maneja la excepción pero sigue corriendo el programa aún saltando esa excepción.
    }

    public LinkedList<User> getAllUsers() throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        LinkedList<User> users = new LinkedList<>();
        JSONObject jsonObject;

// This will reference one line at a time
        String line = null;
// FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(JSONFILEPATH);
// Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            jsonObject = (JSONObject) new JSONParser().parse(line);

            User user = new User();
            user.setName(jsonObject.get("name").toString());
            user.setId(jsonObject.get("id").toString());
            user.setPhone(jsonObject.get("phone").toString());
            user.setUsername(jsonObject.get("username").toString());
            user.setPassword(jsonObject.get("password").toString());
            user.setDisabilityPresented((boolean) jsonObject.get("disabilityPresented"));
            user.setRole(jsonObject.get("role").toString());
            System.out.println(user.toString());
            users.add(user);
        }
// Always close files.
        bufferedReader.close();

// Or we could just do this:
// ex.printStackTrace();
        return users;
    }

    public User getUser(String username) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        User user = new User();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;
        FileReader fileReader = null;

        // FileReader reads text files in the default encoding.
        if (new File(JSONFILEPATH).exists()) {

            fileReader = new FileReader(JSONFILEPATH);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("username").toString().equals(username)) {
                    user.setName(jsonObject.get("name").toString());
                    user.setId(jsonObject.get("id").toString());
                    user.setPhone(jsonObject.get("phone").toString());
                    user.setUsername(jsonObject.get("username").toString());
                    user.setPassword(jsonObject.get("password").toString());
                    user.setDisabilityPresented((boolean) jsonObject.get("disabilityPresented"));
                    user.setRole(jsonObject.get("role").toString());
                }

            }
            // Always close files.
            bufferedReader.close();
        } else {
            //Crea archivo
            FileWriter file = new FileWriter(JSONFILEPATH);
            file.close();

        }
        return user;
    }

    public User getUser(String username, String password) throws ParseException, IOException, org.json.simple.parser.ParseException {

        User user = new User();
        JSONObject jsonObject;//THIRD PARTY

        // This will reference one line at a time
        String line = null;

        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(JSONFILEPATH);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {

            jsonObject = (JSONObject) new JSONParser().parse(line);

            if (jsonObject.get("username").toString().equals(username) && jsonObject.get("password").toString().equals(password)) {
                user.setName(jsonObject.get("name").toString());
                user.setId(jsonObject.get("id").toString());
                user.setPhone(jsonObject.get("phone").toString());
                user.setUsername(jsonObject.get("username").toString());
                user.setPassword(jsonObject.get("password").toString());
                user.setDisabilityPresented((boolean) jsonObject.get("disabilityPresented"));
                user.setRole(jsonObject.get("role").toString());

            } else {
                System.out.println("");
            }

        }
        // Always close files.
        bufferedReader.close();

        return user;
    }

    public void deleteUser(String username) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        JSONObject userObject;

        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("Users.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                userObject = (JSONObject) new JSONParser().parse(line);

                if (!userObject.get("username").toString().equals(username)) {

                    printWriter.println(line);
                    printWriter.flush();
                }
            }

            bufferedReader.close();
        }

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);

    }

    public void modifyUserFromFile(String username, User user) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        JSONObject userObject;

        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("Users.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

        String line = null;

        //Read from the original file and write to the new 
        //unless content matches data to be removed.
        while ((line = bufferedReader.readLine()) != null) {

            userObject = (JSONObject) new JSONParser().parse(line);

            if (!userObject.get("username").toString().equals(username)) {

                printWriter.println(line);
                printWriter.flush();
            } else {

                userObject.put("name", user.getName());
                userObject.put("id", user.getId());
                userObject.put("phone", user.getPhone());
                userObject.put("username", user.getUsername());
                userObject.put("password", user.getPassword());
                userObject.put("disabilityPresented", user.isDisabilityPresented());
                userObject.put("role", "customer");

                printWriter.println(userObject.toJSONString());
            }
        }

        bufferedReader.close();
        printWriter.close();

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);
    }

    public void setCurrentUser(String username) {
        currentUsername = username;
    }

    public String getCurrentUser() {
        return currentUsername;
    }
}
