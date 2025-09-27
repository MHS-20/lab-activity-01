package Remote.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        ModelRemote model = (ModelRemote) registry.lookup("Model");
        ControllerRemote controller = (ControllerRemote) registry.lookup("Controller");

        MyView view = new MyView(model, controller);
        controller.setView(view);

        view.setDefaultCloseOperation(MyView.EXIT_ON_CLOSE);
        view.setVisible(true);
    }
}