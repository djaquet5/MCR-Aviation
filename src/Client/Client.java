package Client;


public class Client {
    private static int _id = 0;

    private String surname;
    private String name;
    private int id;
    private double credit;
    private int miles;
    private Staus staus;
    private String lastAction;

    public Client(String surname, String name) {
        this.surname = surname;
        this.name = name;
        id = _id++;
        lastAction = "";
        credit = 0;
        miles = 0;
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

    public String getLastAction() {
        return lastAction;
    }
}
