package Remote.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ModelRemote extends Remote {
    int getState() throws RemoteException;
    void incrementState() throws RemoteException;
}