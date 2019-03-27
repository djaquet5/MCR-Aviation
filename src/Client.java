import java.util.LinkedList;

public class Client {
    private static int _id = 0;

    private String surname;
    private String name;
    private int id;
    private int lastAction;
    public static LinkedList observers = new LinkedList<Observer>();

    public Client(String surname, String name) {
        this.surname = surname;
        this.name = name;
        id = _id++;
        lastAction = 0;
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

    public int getLastAction() {
        return lastAction;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void deleteObservers() {
        observers.clear();
    }

    public void notifyObservers(Object arg) {
        
    }
}
