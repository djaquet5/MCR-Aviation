package Observers;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class StatusObserver implements Observer {
    private ArrayList<JLabel> clientList = new ArrayList<>();
    private ArrayList<Integer> clientIds = new ArrayList<>();

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



        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void update(Client client) {
        clientList.get(clientIds.indexOf(client.getId())).setText(client.toString() + " " + client.getStatus().toString());
        clientList.get(clientIds.indexOf(client.getId())).setForeground(client.getStatus().getColor());
    }
}
