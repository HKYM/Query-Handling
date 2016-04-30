package com.inpt.model;

public class User {
	private int id;
    private String firstName;
    private String lastName;
    private String groups;
    private String image;
    
    
    public User(int id, String firstName, String lastName, String groups, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groups= groups;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
