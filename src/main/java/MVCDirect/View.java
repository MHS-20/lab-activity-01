package MVCDirect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends JFrame implements ActionListener {

    Controller controller;
    Model model;

    public View(Model m, Controller c){
        super("My BBoM App");

        this.controller = c;
        //this.model = m;

        setSize(300, 70);
        setResizable(false);

        var updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        System.out.println("State value: " + m.getState());

        var panel = new JPanel();
        panel.add(updateButton);

        setLayout(new BorderLayout());
        add(panel,BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }
        });
    }

    public void actionPerformed(ActionEvent ev) {
        controller.increment();
    }

    public void update(int value) {
        System.out.println("State value: " + value);
    }

}
