package Remote.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControllerRemote extends Remote {
    void increment() throws RemoteException;
    void setView(ViewRemote view) throws RemoteException;
}