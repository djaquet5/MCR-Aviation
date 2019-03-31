package Flight;

abstract class Ticket {
    protected Flight flight;
    protected int moneyCoefficient;
    protected int milesCoefficient;

    public Ticket(Flight flight) {
        this.flight = flight;
    }

    public double payMoney() {
        return flight.getPrice() * moneyCoefficient;
    }

    public double payMiles() {
        return flight.getDistance() * milesCoefficient;
    }
}
