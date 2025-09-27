package Extensions.Observer;

import javax.swing.*;

public class OutputGUIView extends JFrame implements Observer, common.View {
    private JLabel counterLabel;
    private Model model;

    public OutputGUIView(Model model) {
        this.model = model;
        this.model.addObserver(this);

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
