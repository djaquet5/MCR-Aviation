package Client;

import Observers.Observer;
import Status.*;

import java.util.ArrayList;

public class Client implements Comparable{
    private ArrayList<Observer> observers = new ArrayList<>();
    private static int _id = 0;

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
        id = _id++;
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
        observerNotify();
    }

    /**
     * adds miles to the client
     * @param miles miles to add
     */
    public void addMiles(double miles) {
        this.miles += miles;
        observerNotify();
    }

    /**
     * adds credits to the client
     * @param credit credits to add
     */
    public void addCredit(double credit) {
        this.credit += credit;
        observerNotify();
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
    public void observerNotify(){
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