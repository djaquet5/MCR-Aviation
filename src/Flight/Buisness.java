package Flight;

public class Buisness extends Ticket {
    public Buisness(Flight flight) {
        super(flight);
        moneyCoefficient = 2;
        milesCoefficient = 5;
    }
}