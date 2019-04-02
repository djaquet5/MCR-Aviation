package Flight;

public class Flight {
    private String name;
    private int distance;
    private int price;
    private Ticket[] tickets;

    public Flight(String name, int distance, int price) {
        this.name = name;
        this.distance = distance;
        this.price = price;

        tickets = new Ticket[] {
                                    new Economy(this),
                                    new Business(this),
                                    new First(this)
                               };
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getPrice() {
        return price;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return name;
    }
}
