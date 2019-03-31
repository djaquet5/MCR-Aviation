package Status;

public class Platinium extends Status {
    public Platinium(Status status) {
        super(status);
    }

    @Override
    void thresholdCheck() {
        if (client.getMiles() < goldThreshold) {
            client.setStatus(new Gold(this));
        } else if (client.getMiles() >= goldThreshold) {
            client.setStatus(new PermaPlat(this));
        }
    }
}