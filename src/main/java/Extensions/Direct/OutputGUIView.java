package Extensions.Direct;

import javax.swing.*;

public class OutputGUIView extends JFrame implements common.View {
    private JLabel counterLabel;
    private Model model;

    public OutputGUIView(Model model) {
        this.model = model;

        counterLabel = new JLabel("Contatore: " + model.getState());
        add(counterLabel);

        setTitle("Contatore GUI");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update() {
        counterLabel.setText("Contatore: " + model.getState());
    }
}
