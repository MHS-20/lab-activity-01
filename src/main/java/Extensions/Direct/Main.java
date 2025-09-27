package Extensions.Direct;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        MyController controller = new MyController(model);

        InputGUIView inputView = new InputGUIView(model, controller);
        OutputGUIView outputView = new OutputGUIView(model);

        controller.setView(inputView);
        controller.setView(outputView);

        SwingUtilities.invokeLater(() -> {
            outputView.setVisible(true);
            inputView.setVisible(true);
        });

        ConsoleInput inputConsoleView = new ConsoleInput(controller);
        inputConsoleView.start();
    }
}
