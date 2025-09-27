package MVC.Direct;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        MyController controller = new MyController(model);
        MyView view = new MyView(model, controller);
        controller.setView(view);
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
