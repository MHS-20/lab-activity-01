package Extensions.Observer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

        MyView inputView = new MyView(model, controller);
        OutputGUIView outputView = new OutputGUIView(model);

        model.addObserver(inputView);
        model.addObserver(outputView);

        SwingUtilities.invokeLater(() -> {
            inputView.setVisible(true);
            outputView.setVisible(true);
        });

        ConsoleInput inputConsoleView = new ConsoleInput(controller);
        inputConsoleView.start();
    }
}
