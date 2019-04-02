package Flight;

/**
 * Economy class ticket
 */
public class Economy extends Ticket {
    public Economy(Flight flight) {
        super(flight);

        setMoneyCoefficient(1);
        setMilesCoefficient(1);
    }
}