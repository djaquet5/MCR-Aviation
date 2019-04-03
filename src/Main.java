/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Main.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019
 -----------------------------------------------------------------------------------
*/

import Client.*;
import Flight.Flight;

import java.util.ArrayList;

/**
 * Main to launch and test the application
 */
public class Main {
   public static void main(String... args) {
      Client c1 = new Client("David", "Jaquet");
      Client c2 = new Client ("Yoann", "Rohrbasser");
      Client c3 = new Client ("Sarah", "Conor");
      Client c4 = new Client ("Kara", "Thrace");
      Client c5 = new Client ("Takeshi", "Kovacs");
      Client c6 = new Client ("Jean Luc", "Picard");
      Client c7 = new Client ("John", "Sheridan");
      Client c8 = new Client ("Samantha", "Carter");
      Client c9 = new Client ("Malcolm", "Reynolds");
      Client c10 = new Client ("Joe", "Miller");
      ArrayList<Client> clients = new ArrayList<>();
      clients.add(c1);
      clients.add(c2);
      clients.add(c3);
      clients.add(c4);
      clients.add(c5);
      clients.add(c6);
      clients.add(c7);
      clients.add(c8);
      clients.add(c9);
      clients.add(c10);

      Flight f1 = new Flight("U2-4", 100, 20);
      Flight f2 = new Flight("LX-32", 500, 200);
      Flight f3 = new Flight("UA-43", 1000, 500);
      Flight f4 = new Flight("EK-24", 1000, 3000);
      Flight f5 = new Flight("KL-25", 200, 300);
      Flight f6 = new Flight("LH-9", 400, 800);
      ArrayList<Flight> flights = new ArrayList<>();
      flights.add(f1);
      flights.add(f2);
      flights.add(f3);
      flights.add(f4);
      flights.add(f5);
      flights.add(f6);

      new ClientManager(clients, flights);
   }
}