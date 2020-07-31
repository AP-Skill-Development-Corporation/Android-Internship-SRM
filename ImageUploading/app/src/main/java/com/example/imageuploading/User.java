package com.example.imageuploading;

public class User {
    private String name,mobileno,filelocation;

    public User() {
    }

    public User(String name, String mobileno, String filelocation) {
        this.name = name;
        this.mobileno = mobileno;
        this.filelocation = filelocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getFilelocation() {
        return filelocation;
    }

    public void setFilelocation(String filelocation) {
        this.filelocation = filelocation;
    }
}
