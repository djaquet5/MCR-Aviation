import Frames.ClientManager;
import Client.*;
import Flight.*;

import java.util.ArrayList;

public class Main {
   public static void main(String... args) {
      Client c1 = new Client("David", "Jaquet");
      Client c2 = new Client ("Yoann", "Rohrbasser");
      ArrayList<Client> clients = new ArrayList<Client>();
      clients.add(c1);
      clients.add(c2);

      Flight f1 = new Flight("F1", 123, 1);
      Flight f2 = new Flight("F2", 789, 2);
      Flight f3 = new Flight("F3", 34, 3);
      ArrayList<Flight> flights = new ArrayList<Flight>();
      flights.add(f1);
      flights.add(f2);
      flights.add(f3);

      new ClientManager(clients, flights);
   }
}