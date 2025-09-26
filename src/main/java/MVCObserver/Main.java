package MVCObserver;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);
        model.addObserver(view);
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
