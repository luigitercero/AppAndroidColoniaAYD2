package com.example.luigitercero.appcolonia;

public class LoginToken {
    private static LoginToken instance;
    private static String correo;
    private static String idCodigo;

    private LoginToken(){}

    public void setCorreo(String correo) {
        LoginToken.correo = correo;
    }
    public void setIdCodigo(String codigo) {LoginToken.idCodigo = codigo;}

    public  String getCorreo() {
        return LoginToken.correo;
    }
    public String getIdCodigo() {return LoginToken.idCodigo;}
    public static synchronized LoginToken getInstance(){
        if(instance == null){
            instance = new LoginToken();
        }else {
            return instance;
        }
        return instance;
    }
}
