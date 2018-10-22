package com.example.luigitercero.appcolonia.Models;

public class User {


    public User(String correo, String contrasenia) {
        Correo = correo;
        Contrasenia = contrasenia;
        type = 0;
    }

    private String Correo;
    private String Contrasenia;
    private int type;
    private int error;
    private String respose;
    private boolean acces;



    public boolean isAcces() {
        return acces;
    }



}
