/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Client.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019
 -----------------------------------------------------------------------------------
*/

package Client;

import Observers.Observer;
import Status.*;

import java.util.ArrayList;

/**
 * Client account
 */
public class Client implements Comparable{
    private ArrayList<Observer> observers = new ArrayList<>();
    private static int nbClients = 0;

    private String lastName;
    private String firstName;
    private int id;
    private double credit;
    private double miles;
    private Status status;
    private String lastAction;

    /**
     * Client constructor
     * @param lastName client's last name
     * @param firstName client's first name
     */
    public Client(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        id = nbClients++;
        credit = 0;
        miles = 0;
        status = new Silver(this);
        lastAction = "";
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public double getCredit() {
        return credit;
    }

    public double getMiles() {
        return miles;
    }

    public String getLastAction() {
        return lastAction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        notifyObserver();
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
        notifyObserver();
    }

    /**
     * adds miles to the client dependant on the status
     * @param miles miles to add
     */
    public void addMiles(double miles) {
        this.miles += miles * status.getCoefficient();
        status.thresholdCheck();
        notifyObserver();
    }

    /**
     * pay for a ticket with miles
     * @param miles miles to pay
     */
    public void payMiles(double miles) {
        this.miles -= miles;
        status.thresholdCheck();
        notifyObserver();
    }

    /**
     * adds credits to the client
     * @param credit credits to add
     */
    public void addCredit(double credit) {
        this.credit += credit;
        status.thresholdCheck();
        notifyObserver();
    }

    /**
     * pay for a ticket with credits
     * @param credit credits to pay
     */
    public void payCredit(double credit) {
        addCredit(-credit);
    }

    /**
     * add an observer to the client
     * @param observer the observer to add
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * remove an observer from the client
     * @param observer the observer to remove
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * notify all observers to update in case of a change
     */
    public void notifyObserver(){
        for (Observer observer : observers)
            observer.update(this);
    }

    @Override
    public String toString(){
        return lastName + " " + firstName;
    }

    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }
}