package Flight;

public abstract class Ticket {
    private int moneyCoefficient;
    private int milesCoefficient;

    private Flight flight;


    public Ticket(Flight flight) {
        this.flight = flight;
    }

    public void setMoneyCoefficient(int newCoeff) {
        moneyCoefficient = newCoeff;
    }

    public void setMilesCoefficient(int newCoeff) {
        milesCoefficient = newCoeff;
    }

    public double getMoneyCost() {
        return flight.getPrice() * moneyCoefficient;
    }

    public double getMilesCost() {
        return flight.getPrice() * milesCoefficient;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getMoneyCost() + "$";
    }
}
