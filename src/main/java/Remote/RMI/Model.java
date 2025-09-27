package Remote.RMI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Model extends UnicastRemoteObject implements ModelRemote {
    private int state;

    public Model() throws RemoteException {
        super();
        state = 0;
    }

    public void incrementState() throws RemoteException {
        state++;
    }

    public int getState() throws RemoteException {
        return state;
    }
}