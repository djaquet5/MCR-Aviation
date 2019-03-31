package Status;

import Client.Client;

public class Silver extends Status {

    public Silver(Client client) {
        super(client);
    }

    Silver(Status status) {
        super(status);
    }

    @Override
    double getCoefficient() {
        return 0.1;
    }

    @Override
    void thresholdCheck() {
        if (client.getMiles() >= silverThreshold) {
            client.setStatus(new Gold(this));
        }
    }

}
