package Remote.RMI;

import common.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;

public class MyView extends JFrame implements ActionListener, ViewRemote {

    private ModelRemote model;
    private ControllerRemote controller;

    public MyView(ModelRemote m, ControllerRemote c) throws RemoteException {
        super("My BBoM App");

        this.controller = c;
        this.model = m;

        setSize(300, 70);
        setResizable(false);

        var updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        // System.out.println("State value: " + m.getState());

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
        try {
            // System.out.println("Controller increment: ");
            controller.increment();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() throws RemoteException {
        System.out.println("Update called");
        int current = model.getState();
        System.out.println("State value: " + current);
    }
}