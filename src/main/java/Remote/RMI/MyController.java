package Remote.RMI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MyController extends UnicastRemoteObject implements ControllerRemote {
    private ModelRemote model;
    private ViewRemote view;

    public MyController(ModelRemote m) throws RemoteException {
        super();
        this.model = m;
    }

    public void setView(ViewRemote v) throws RemoteException {
        this.view = v;
    }

    public void increment() throws RemoteException {
        System.out.println("Controller called");
        model.incrementState();
        if (view != null){
            view.update();
            System.out.println("View update");
        } else{
            System.out.println("View not set");
        }
    }
}
