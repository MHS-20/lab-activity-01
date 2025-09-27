package Concurrency.Observer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();

        MyController controller = new MyController(model);
        MyView view = new MyView(model, controller);

        model.addObserver(view);
        controller.start();

        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
