/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : StatusObserver.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019

 Remarque(s) :

 -----------------------------------------------------------------------------------
*/

package Observers;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Observer for Status window
 */
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

        panel.setLayout(new GridLayout(clients.size(), 1));
        for (int i = 0; i < clients.size(); i++) {
            panel.add(clientList.get(i));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 300, 100);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(300, 100));
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
        int index = clientIds.indexOf(client.getId());

        clientList.get(index).setText(client.toString() + " " +
                                      client.getStatus().toString());

        clientList.get(index).setForeground(client.getStatus().getColor());
    }
}
