public class Client implements ClientStatus{
    private static int _id = 0;

    private String surname;
    private String name;
    private int id;
    private int lastAction;

    public Client(String surname, String name) {
        this.surname = surname;
        this.name = name;
        id = _id++;
        lastAction = 0;
    }


}
