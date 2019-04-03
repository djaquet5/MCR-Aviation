/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Ticket.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019

 Remarque(s) :

 -----------------------------------------------------------------------------------
*/

package Flight;

/**
 * Governing class for all tickets
 */
public abstract class Ticket {
    private int moneyCoefficient;
    private int milesCoefficient;

    private Flight flight;

    /**
     * Ticket constructor
     * @param flight the corresponding flight
     */
    public Ticket(Flight flight) {
        this.flight = flight;
    }

    public void setMoneyCoefficient(int newCoeff) {
        moneyCoefficient = newCoeff;
    }

    public void setMilesCoefficient(int newCoeff) {
        milesCoefficient = newCoeff;
    }

    /**
     * Get the price in credit of a flight for a specific class
     * @return the price of the ticket
     */
    public double getMoneyCost() {
        return flight.getPrice() * moneyCoefficient;
    }

    /**
     * Get the price in miles of a flight for a specific class
     * @return the price of the ticket
     */
    public double getMilesCost() {
        return flight.getPrice() * milesCoefficient;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getMoneyCost() + "$";
    }
}
