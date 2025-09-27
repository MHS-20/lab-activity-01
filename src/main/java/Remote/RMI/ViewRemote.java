package Remote.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ViewRemote extends Remote {
    void update() throws RemoteException;
}