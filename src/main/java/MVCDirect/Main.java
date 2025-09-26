package MVCDirect;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
        controller.setView(view);
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
