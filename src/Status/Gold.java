package Status;

class Gold extends Status {
    Gold(Status status) {
        super(status);
    }

    @Override
    double getCoefficient() {
        return 0.5;
    }

    @Override
    void thresholdCheck() {
        if (client.getMiles() < silverThreshold) {
            client.setStatus(new Silver(this));
        } else if (client.getMiles() >= goldThreshold) {
            client.setStatus(new Platinum(this));
        }
    }
}