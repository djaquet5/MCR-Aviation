package Status;

import Client.Client;

import java.awt.*;

public abstract class Status {
    static final int silverThreshold = 1000;
    static final int goldThreshold = 10000;
    static final int platinumThreshold = 100000;

    protected Client client;

    public Status(Client client) {
        this.client = client;
    }

    public Status(Status status) {
        this.client = status.getClient();
    }

    public Client getClient() {
        return client;
    }

    abstract double getCoefficient();
    abstract void thresholdCheck();
    abstract Color getColor();
}
