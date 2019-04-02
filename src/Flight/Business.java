package Flight;

public class Business extends Ticket {
    public Business(Flight flight) {
        super(flight);

        setMoneyCoefficient(2);
        setMilesCoefficient(5);
    }
}