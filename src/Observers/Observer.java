package Observers;

import Client.Client;

public interface Observer {
    /**
     * updates the panel parameters for a given client
     * @param client the client to update
     */
    void update(Client client);
}
