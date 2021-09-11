import java.rmi.RemoteException;

public interface Registrador extends java.rmi.Remote {

    public String prueba()throws java.rmi.RemoteException;

   public boolean registrar(Oferta consulta) throws java.rmi.RemoteException;

   public void consultar() throws java.rmi.RemoteException;
}
