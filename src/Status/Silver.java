package Status;

import Client.Client;

import java.awt.*;

/**
 * Silver status
 */
public class Silver extends Status {

    public Silver(Client client) {
        super(client);
    }

    Silver(Status status) {
        super(status);
    }

    @Override
    public double getCoefficient() {
        return 0.1;
    }

    @Override
    public void thresholdCheck() {
        if (client.getMiles() >= silverThreshold) {
            client.setStatus(new Gold(this));
        }
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {
        return "SILVER";
    }
}
