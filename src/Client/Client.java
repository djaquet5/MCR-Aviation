package Client;

import Status.*;

public class Client {
    private static int _id = 0;

    private String surname;
    private String name;
    private int id;
    private double credit;
    private int miles;
    private Status status;
    private String lastAction;

    public Client(String surname, String name) {
        this.surname = surname;
        this.name = name;
        id = _id++;
        credit = 0;
        miles = 0;
        status = new Silver(this);
        lastAction = "";
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
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
}
