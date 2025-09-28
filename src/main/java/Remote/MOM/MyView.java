package Remote.MOM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyView extends JFrame implements ActionListener, common.View {

    int state;

    public MyView(int initState){
        super("My BBoM App");

        this.state = initState;

        setSize(300, 70);
        setResizable(false);

        var updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        System.out.println("State value: " + initState);

        var panel = new JPanel();
        panel.add(updateButton);

        setLayout(new BorderLayout());
        add(panel,BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }
        });

        new Thread(() -> {
            try {
                RabbitMQUtil.setup();
                RabbitMQUtil.consumeMessages((consumerTag, delivery) -> {
                    String message = new String(delivery.getBody(), "UTF-8");
                    if (message.startsWith("state:")) {
                        String value = message.substring(6);
                        state = Integer.parseInt(value);
                        update();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void actionPerformed(ActionEvent ev) {
        try {
            RabbitMQUtil.sendMessage("increment");
        } catch (Exception e) {
            e.printStackTrace();
        }    }

    public void update() { System.out.println("State value: " + state); }
}