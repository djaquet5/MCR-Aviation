package Frames;

import Client.Client;
import Flight.Flight;
import Observers.StatusObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientManager {
   private JFrame frame;

   private JPanel panel = new JPanel();
   private JComboBox<Client> clients = new JComboBox<>();
   private JComboBox<Flight> flights = new JComboBox<>();
   private JTextField creditsText = new JTextField(5);

   private final int width = 600;
   private final int height = 200;

   public ClientManager(ArrayList<Client> clients, ArrayList<Flight> flights) {
      frame = new JFrame("Clients manager");
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      initClient(clients);
      initCredit();
      initFlight();
      initButton(clients);

      frame.add(panel);

      frame.setSize(width, height);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   private void initClient(ArrayList<Client> clients) {
      JPanel clientPanel = new JPanel();

      clientPanel.add(new JLabel("Clients"));

      for(Client c : clients)
         this.clients.addItem(c);

      clientPanel.add(this.clients);

      JButton details = new JButton("Details");
      details.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("COCOUC");
         }
      });
      clientPanel.add(details);

      panel.add(clientPanel);
   }

   private void initCredit() {
      JPanel creditPanel = new JPanel();
      creditPanel.add(new JLabel("Credits"));

//      creditsText.setSize(100, JTextField.HEIGHT);
      creditPanel.add(creditsText);

      JButton addButton = new JButton("Add");
      addButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("Add");
         }
      });
      creditPanel.add(addButton);

      panel.add(creditPanel);
   }

   private void initFlight() {
      panel.add(new JLabel("Flight"));
   }

   private void initButton(ArrayList<Client> clients) {
      JPanel buttonPanel = new JPanel();

      JButton statuses = new JButton("Statuses");
      statuses.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new StatusObserver(clients);
         }
      });
      buttonPanel.add(statuses);

      panel.add(buttonPanel);
   }
}
