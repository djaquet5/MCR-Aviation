package Status;

class Platinum extends Status {
    Platinum(Status status) {
        super(status);
    }

    @Override
    double getCoefficient() {
        return 1;
    }

    @Override
    void thresholdCheck() {
        if (client.getMiles() < goldThreshold) {
            client.setStatus(new Gold(this));
        } else if (client.getMiles() >= platinumThreshold) {
            client.setStatus(new PermaPlat(this));
        }
    }
}