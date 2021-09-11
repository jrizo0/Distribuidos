import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Oferta implements Serializable{
    //atributos
    String empresa;
    String cargo;
    String sueldo;

    //constructor
    public Oferta(String empresa, String cargo, String sueldo) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Oferta() {
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
}
