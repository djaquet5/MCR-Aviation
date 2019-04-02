package Frames;

import Client.Client;
import Flight.Flight;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientManager {
   private JFrame frame;

   private JPanel panel = new JPanel();
   private JComboBox<Client> clients = new JComboBox<>();
   private JComboBox<Flight> flights = new JComboBox<>();

   public ClientManager(ArrayList<Client> clients, ArrayList<Flight> flights) {
      frame = new JFrame("Clients manager");

      initClient(clients);
      initCredit();
      initFlight();

      frame.add(panel);

      frame.setSize(600, 200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   private void initClient(ArrayList<Client> clients) {
      panel.add(new JLabel("Clients"));

      for(Client c : clients)
         this.clients.addItem(c);

      panel.add(this.clients);

      JButton button = new JButton("Details");
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("COCOUC");
         }
      });

      panel.add(button);
   }

   private void initCredit() {
      panel.add(new JLabel("Credits"));
   }

   private void initFlight() {
      panel.add(new JLabel("Flight"));
   }
}
