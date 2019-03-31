package Flight;

public class First extends Ticket {
    public First(Flight flight) {
        super(flight);
        moneyCoefficient = 5;
        milesCoefficient = 30;
    }
}