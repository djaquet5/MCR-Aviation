package Observers;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

public class StatusObserver implements Observer {
    private ArrayList<JLabel> clientList = new ArrayList<>();
    private ArrayList<Integer> clientIds = new ArrayList<>();

    /**
     * StatusObserver constructor
     * @param clients list of clients to observe
     */
    public StatusObserver(ArrayList<Client> clients) {
        Collections.sort(clients);

        for (Client client : clients) {
            client.addObserver(this);
            clientList.add(new JLabel());
            clientIds.add(client.getId());
            update(client);
        }

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 0; i < clients.size(); i++) {
            panel.add(clientList.get(i));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 500, 500);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 300));
        contentPane.add(scrollPane);
        frame.setContentPane(contentPane);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                for (Client client : clients) {
                    client.removeObserver(StatusObserver.this);
                }
            }
        });
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Statuses");
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void update(Client client) {
        clientList.get(clientIds.indexOf(client.getId())).setText(client.toString() + " " + client.getStatus().toString());
        clientList.get(clientIds.indexOf(client.getId())).setForeground(client.getStatus().getColor());
    }
}
