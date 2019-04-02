package Observers;

import Client.Client;

import javax.swing.*;
import java.util.ArrayList;

public class ClientObserver implements Observer{
    private final JLabel lastName = new JLabel();
    private final JLabel firstName = new JLabel();
    private final JLabel credit = new JLabel();
    private final JLabel miles = new JLabel();
    private final JLabel status = new JLabel();
    private final JLabel lastAction = new JLabel();

    public ClientObserver(Client client) {

    }

    @Override
    public void update(Client client) {

    }
}
