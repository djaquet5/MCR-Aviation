package Frames;

import Client.Client;
import Flight.Flight;
import Flight.Ticket;
import Observers.ClientObserver;
import Observers.StatusObserver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ClientManager {
   private JFrame frame;

   private JPanel panel = new JPanel();
   private JComboBox<Client> clients = new JComboBox<>();
   private JComboBox<Flight> flights = new JComboBox<>();
   private JComboBox<Ticket> tickets = new JComboBox<>();
   private JTextField creditsText = new JTextField(5);

   private final int width = 600;
   private final int height = 200;

   public ClientManager(ArrayList<Client> clients, ArrayList<Flight> flights) {
      frame = new JFrame("Clients manager");
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      initClient(clients);
      initCredit();
      initFlight(flights);
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
            new ClientObserver(getCurrentClient());
         }
      });
      clientPanel.add(details);

      panel.add(clientPanel);
   }

   private void initCredit() {
      JPanel creditPanel = new JPanel();
      creditPanel.add(new JLabel("Credits"));
      creditPanel.add(creditsText);

      JButton addButton = new JButton("Add");
      addButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Client client = getCurrentClient();

            client.addCredit(Double.parseDouble(creditsText.getText()));
            client.setLastAction(creditsText.getText() + "$ added");
         }
      });
      creditPanel.add(addButton);

      panel.add(creditPanel);
   }

   private void initFlight(ArrayList<Flight> flights) {
      JPanel flightsPanel = new JPanel();
      flightsPanel.add(new JLabel("Flight"));

      for(Flight f : flights)
         this.flights.addItem(f);

      this.flights.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            loadTickets();
         }
      });

      loadTickets();
      flightsPanel.add(this.flights);
      flightsPanel.add(tickets);

      JButton cash = new JButton("Book (cash)");
      cash.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Client client = getCurrentClient();
            double cost = getCurrentTicket().getMoneyCost();

            if(client.getCredit() < cost) {
               client.setLastAction("Try to book with cash. Amount of cash is not enough");
               return;
            }

            // Multiply by -1 to remove some credits
            client.payCredit(cost);

            Flight flight = getCurrentFlight();
            client.addMiles(flight.getDistance());
            client.setLastAction(flight + " booked with cash, have a pleasant fly");
         }
      });
      flightsPanel.add(cash);

      JButton miles = new JButton("Book (miles)");
      miles.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Client client = getCurrentClient();
            double cost = getCurrentTicket().getMilesCost();

            if(client.getMiles() < cost) {
               client.setLastAction("Try to book with miles. Amount of miles is not enough");
               return;
            }

            // Multiply by -1 to remove some miles
            client.payMiles(cost);
            client.setLastAction(getCurrentFlight() + " booked with cash, have a pleasant fly");
         }
      });
      flightsPanel.add(miles);

      panel.add(flightsPanel);
   }

   private void initButton(ArrayList<Client> clients) {
      JPanel buttonsPanel = new JPanel();

      JButton statuses = new JButton("Statuses");
      statuses.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new StatusObserver(clients);
         }
      });
      buttonsPanel.add(statuses);

      JButton quit = new JButton("Quit");
      quit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
         }
      });
      buttonsPanel.add(quit);

      panel.add(buttonsPanel);
   }

   private void loadTickets() {
      tickets.removeAllItems();

      for(Ticket t : getCurrentFlight().getTickets())
         tickets.addItem(t);
   }

   private Client getCurrentClient() {
      return (Client) clients.getSelectedItem();
   }

   private Flight getCurrentFlight() {
      return (Flight) flights.getSelectedItem();
   }

   private Ticket getCurrentTicket() {
      return (Ticket) tickets.getSelectedItem();
   }
}
