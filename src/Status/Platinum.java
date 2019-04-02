package Status;

import java.awt.*;

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
        } else if (client.getCredit() >= platinumThreshold) {
            client.setStatus(new PermaPlat(this));
        }
    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    @Override
    public String toString() {
        return "PLATINUM";
    }
}