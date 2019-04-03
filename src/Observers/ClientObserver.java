package Observers;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Observer for client status window
 */
public class ClientObserver implements Observer{
    private  JLabel credits = new JLabel();
    private  JLabel miles = new JLabel();
    private  JLabel status = new JLabel();
    private  JLabel lastAction = new JLabel();

    /**
     * ClientObserver constructor
     * @param client the client to observe
     */
    public ClientObserver(Client client) {
        client.addObserver(this);
        update(client);
        
        JLabel lastName = new JLabel();
        lastName.setText("Last name: " + client.getLastName());
        JLabel firstName = new JLabel();
        firstName.setText("First name: " + client.getFirstName());

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(400, 200));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                client.removeObserver(ClientObserver.this);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(lastName);
        panel.add(firstName);
        panel.add(credits);
        panel.add(miles);
        panel.add(status);
        panel.add(lastAction);

        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.setTitle("Details of client #" + client.getId());
        frame.setVisible(true);
    }

    @Override
    public void update(Client client) {
        credits.setText("Credits: " + client.getCredit());
        miles.setText("Nb miles: " + client.getMiles());
        status.setText("Status: " + client.getStatus());
        lastAction.setText("Last action: " + client.getLastAction());
    }
}
