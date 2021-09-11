/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;


/**
 *
 * @author usuario
 */
public class RegistradorImpl extends UnicastRemoteObject implements Registrador {

    public RegistradorImpl(String name) throws RemoteException {
        super();
        try {
            System.out.println("Rebind Object " + name);
            Naming.rebind(name, this);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String prueba() throws RemoteException {
        try {
            return ("holiaaaaaa");

        } catch (Exception e) {
            e.printStackTrace();
            return("error");
        }
    }

   public void consultar() throws RemoteException {
     File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
          // hacer una lectura comoda (disponer del metodo readLine()).
          archivo = new File ("C:\\archivo.txt");
          fr = new FileReader (archivo);
          br = new BufferedReader(fr);
          // Lectura del fichero
          String linea;
          while((linea=br.readLine())!=null)
             System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
          // En el finally cerramos el fichero, para asegurarnos
          // que se cierra tanto si todo va bien como si salta 
          // una excepcion.
          try{                    
             if( null != fr ){   
                fr.close();     
             }                  
          }catch (Exception e2){ 
             e2.printStackTrace();
          }
      }
   }

   public void registrar(Oferta oferta){
     FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        try {
         //Se crea el fichero
            fos = new FileOutputStream("ofertas",true);                                                 
            salida = new ObjectOutputStream(fos);
            //Se escribe el objeto en el fichero
            salida.writeObject(oferta);
        } catch (FileNotFoundException e) {
                 System.out.println("1: "+e.getMessage());                                                          
        } catch (IOException e) {
                 System.out.println("2: "+e.getMessage());
        } finally {
            try {
                if(fos!=null){
                   fos.close();
                }
                if(salida!=null){
                   salida.close();
                }
            } catch (IOException e) {
                     System.out.println("3: "+e.getMessage());
            }
        }
   }
}
