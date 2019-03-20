enum FlightClass {Economy, Buisness, FirstClass}

public class Ticket {
    private Flight flight;
    private FlightClass flightClass;
    private int[][] coefficients;

    public Ticket(Flight flight, FlightClass flightClass, int[][] coefficients) {
        this.flight = flight;
        this.flightClass = flightClass;
        this.coefficients = coefficients;
    }
}
