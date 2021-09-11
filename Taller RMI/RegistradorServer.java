/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author usuario
 */
public class RegistradorServer {

    public static void main(String args[]) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(7777);
            new RegistradorImpl("rmi://25.12.51.131:7777" + "/MiRegistrador");
        } catch (Exception e) {
            System.err.println("System exception" + e);
        }
    }
}
