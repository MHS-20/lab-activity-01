package MVC.Observer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        MyView view = new MyView(model, controller);
        model.addObserver(view);
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
