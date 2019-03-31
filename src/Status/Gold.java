package Status;

public class Gold extends Status {
    public Gold(Status status) {
        super(status);
    }

    @Override
    void thresholdCheck() {
        if (client.getMiles() < silverThreshold) {
            client.setStatus(new Silver(this));
        } else if (client.getMiles() >= goldThreshold) {
            client.setStatus(new Platinium(this));
        }
    }
}