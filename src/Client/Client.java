package Client;

import Observers.Observer;
import Status.*;

import java.util.ArrayList;

public class Client {
    private ArrayList<Observer> observers = new ArrayList<>();
    private static int _id = 0;

    private String lastName;
    private String firstName;
    private int id;
    private double credit;
    private int miles;
    private Status status;
    private String lastAction;

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

    public int getMiles() {
        return miles;
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void addCredit(double credit) {
        this.credit += credit;
    }

    private void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public String toString(){
        return lastName + " " + firstName;
    }
}