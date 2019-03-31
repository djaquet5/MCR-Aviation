package Flight;

public class Economy extends Ticket {
    public Economy(Flight flight) {
        super(flight);
        moneyCoefficient = 1;
        milesCoefficient = 1;
    }
}