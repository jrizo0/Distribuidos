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
            Registrador miregistrador = (Registrador) Naming.lookup("rmi://" + "25.12.51.131:1099" + "/" + "MiRegistrador");

            System.out.println("Pudo");

            if(args[0].equals("registrar")){
                Oferta consulta = new Oferta();
                consulta.setEmpresa(args[1]);
                consulta.setCargo(args[2]);
                consulta.setSueldo(args[3]);
                if(miregistrador.registrar(consulta))
                    System.out.println("Satisfactoria");
                else{
                    System.out.println("No satisfactoria");
                }
            }
            else if(args[0].equals("consultar")){
                miregistrador.consultar();
            }
        } catch (Exception e) {
            System.err.println(" System exception: "+ e);
        }
        System.exit(0);
    }
}
