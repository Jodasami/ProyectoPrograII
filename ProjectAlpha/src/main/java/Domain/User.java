/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Fabio
 */
public class User {

    private String name;
    private String id;
    private String phone;
    private String username;
    private String password;
    private boolean DisabilityPresented;
    private String role;

    public User(String name, String id, String phone, String username, String password, boolean DisabilityPresented, String role) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.DisabilityPresented = DisabilityPresented;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
    }

    public User(String name, String id, String phone, String username, String password, boolean DisabilityPresented) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.DisabilityPresented = DisabilityPresented;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    
    public boolean isDisabilityPresented() {
        return DisabilityPresented;
    }

    public void setDisabilityPresented(boolean DisabilityPresented) {
        this.DisabilityPresented = DisabilityPresented;
    }

}
