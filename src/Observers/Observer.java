/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Observer.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019
 -----------------------------------------------------------------------------------
*/

package Observers;

import Client.Client;

/**
 * Observer Interface
 */
public interface Observer {
    /**
     * updates the panel parameters for a given client
     * @param client the client to update
     */
    public void update(Client client);
}
