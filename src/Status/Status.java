/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Status.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019

 Remarque(s) :

 -----------------------------------------------------------------------------------
*/

package Status;

import Client.Client;

import java.awt.*;

/**
 * Governing class for all status
 */
public abstract class Status {
    static final int silverThreshold = 1000;
    static final int goldThreshold = 10000;
    static final int platinumThreshold = 100000;

    protected Client client;

    /**
     * Status constructor
     * @param client the client who has this status
     */
    Status(Client client) {
        this.client = client;
    }

    /**
     * Status constructor (only used to change status)
     * @param status the status to change to
     */
    Status(Status status) {
        this.client = status.getClient();
    }

    public Client getClient() {
        return client;
    }

    /**
     * Get the status coefficient
     * @return the percentage of miles you get from a purchase
     */
    public abstract double getCoefficient();

    /**
     * check if the client's current miles update his status
     */
    public abstract void thresholdCheck();

    /**
     * Get the color associated with the status
     * @return the status' color
     */
    public abstract Color getColor();
}
