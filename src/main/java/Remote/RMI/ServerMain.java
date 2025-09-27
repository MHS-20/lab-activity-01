package Remote.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(1099);

        ModelRemote model = new Model();
        ControllerRemote controller = new MyController(model);

        registry.rebind("Model", model);
        registry.rebind("Controller", controller);
    }
}

