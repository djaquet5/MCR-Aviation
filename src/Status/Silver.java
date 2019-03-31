package Status;

import Client.Client;

public class Silver extends Status {

    public Silver(Client client) {
        super(client);
    }

    public Silver(Status status) {
        super(status);
    }

    @Override
    void thresholdCheck() {
        if (client.getMiles() >= silverThreshold) {
            client.setStatus(new Gold(this));
        }
    }

}
