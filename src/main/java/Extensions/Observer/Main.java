package Extensions.Observer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        InputGUIView view = new InputGUIView(model, controller);
        model.addObserver(view);
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
