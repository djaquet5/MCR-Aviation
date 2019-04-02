package Flight;

/**
 * First class ticket
 */
public class First extends Ticket {
    public First(Flight flight) {
        super(flight);

        setMoneyCoefficient(5);
        setMilesCoefficient(30);
    }
}