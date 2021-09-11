import java.rmi.registry.*;
import java.rmi.server.*;
import java.io.Serializable;
import java.rmi.*;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class RegistradorClient {

    public static void main(String args[]) {

        ArrayList ofertasConsulta = new ArrayList();
        Oferta ofertaRegistro;

        try {
            System.out.println("Buscando Objeto ");
            Registrador miregistrador = (Registrador) Naming.lookup("rmi://" + "25.79.109.185:1099" + "/" + "MiRegistrador");


            // if(args[0].equals("registrar")){
                Oferta consulta = new Oferta();
                consulta.setEmpresa("rizo");
                consulta.setCargo("puta");
                consulta.setSueldo("0");
                miregistrador.registrar(consulta);
                System.out.println("Exito");
            // }
            // else if(args[0] == "consultar"){
            //     miregistrador.consultar();
            // }
        } catch (Exception e) {
            System.err.println(" System exception: "+ e);
        }
        System.exit(0);
    }
}
