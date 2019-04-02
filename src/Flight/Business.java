package Flight;

/**
 * Business class ticket
 */
public class Business extends Ticket {
    public Business(Flight flight) {
        super(flight);

        setMoneyCoefficient(2);
        setMilesCoefficient(5);
    }
}