/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : ClientManager.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019

 Remarque(s) : Clients, flights and ticket are stocked in JComboBox

 -----------------------------------------------------------------------------------
*/

package Client;

import Flight.Flight;
import Flight.Ticket;
import Observers.ClientObserver;
import Observers.StatusObserver;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Client manager and main window
 */
public class ClientManager {
   private JFrame frame = new JFrame("Clients manager");

   private JPanel panel = new JPanel();
   private JComboBox<Client> clients = new JComboBox<>();
   private JComboBox<Flight> flights = new JComboBox<>();
   private JComboBox<Ticket> tickets = new JComboBox<>();
   private JTextField creditsText = new JTextField(5);

   private final int frameWidth = 600;
   private final int frameHeight = 200;

   /**
    * Client manager constructor
    * @param clients list of clients
    * @param flights list of flights
    */
   public ClientManager(ArrayList<Client> clients, ArrayList<Flight> flights) {
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      initClient(clients);
      initCredit();
      initFlight(flights);
      initButton(clients);

      frame.add(panel);

      frame.setSize(frameWidth, frameHeight);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   /**
    * Creates client related ui elements
    * @param clients the list of clients
    */
   private void initClient(ArrayList<Client> clients) {
      JPanel clientPanel = new JPanel();

      clientPanel.add(new JLabel("Clients"));

      for(Client c : clients)
         this.clients.addItem(c);

      clientPanel.add(this.clients);

      JButton details = new JButton("Details");
      details.addActionListener(e -> new ClientObserver(getCurrentClient()));
      clientPanel.add(details);

      panel.add(clientPanel);
   }

   /**
    * creates credit related ui elements
    */
   private void initCredit() {
      JPanel creditPanel = new JPanel();
      creditPanel.add(new JLabel("Credits"));
      creditPanel.add(creditsText);

      JButton addButton = new JButton("Add");
      addButton.addActionListener(e -> {
         Client client = getCurrentClient();

         client.addCredit(Double.parseDouble(creditsText.getText()));
         client.setLastAction(creditsText.getText() + "$ added");
      });
      creditPanel.add(addButton);

      panel.add(creditPanel);
   }

   /**
    * Creates flight and booking related ui elements
    * @param flights
    */
   private void initFlight(ArrayList<Flight> flights) {
      JPanel flightsPanel = new JPanel();
      flightsPanel.add(new JLabel("Flight"));

      for(Flight f : flights)
         this.flights.addItem(f);

      this.flights.addActionListener(e -> loadTickets());

      loadTickets();
      flightsPanel.add(this.flights);
      flightsPanel.add(tickets);

      JButton cash = new JButton("Book (cash)");
      cash.addActionListener(e -> {
         Client client = getCurrentClient();
         double cost = getCurrentTicket().getMoneyCost();

         if(client.getCredit() < cost) {
            client.setLastAction(" Tried to book with cash. Amount of cash is not enough");
            return;
         }

         client.payCredit(cost);

         Flight flight = getCurrentFlight();
         client.addMiles(flight.getDistance());
         client.setLastAction(flight + " Booked with cash, have a pleasant flight");
      });
      flightsPanel.add(cash);

      JButton miles = new JButton("Book (miles)");
      miles.addActionListener(e -> {
         Client client = getCurrentClient();
         double cost = getCurrentTicket().getMilesCost();

         if(client.getMiles() < cost) {
            client.setLastAction(" Tried to book with miles. Amount of miles is not enough");
            return;
         }

         client.payMiles(cost);
         client.setLastAction(getCurrentFlight() + " Booked with cash, have a pleasant flight");
      });
      flightsPanel.add(miles);

      panel.add(flightsPanel);
   }

   /**
    * Creates miscellaneous ui elements
    * @param clients
    */
   private void initButton(ArrayList<Client> clients) {
      JPanel buttonsPanel = new JPanel();

      JButton statuses = new JButton("Statuses");
      statuses.addActionListener(e -> new StatusObserver(clients));
      buttonsPanel.add(statuses);

      JButton quit = new JButton("Quit");
      quit.addActionListener(e -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
      buttonsPanel.add(quit);

      panel.add(buttonsPanel);
   }

   /**
    * Adds tickets to the ui
    */
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
