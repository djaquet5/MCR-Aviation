/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Gold.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019

 Remarque(s) :

 -----------------------------------------------------------------------------------
*/

package Status;

import java.awt.*;

/**
 * Gold status
 */
class Gold extends Status {
    Gold(Status status) {
        super(status);
    }

    @Override
    public double getCoefficient() {
        return 0.5;
    }

    @Override
    public void thresholdCheck() {
        if (client.getMiles() < silverThreshold) {
            client.setStatus(new Silver(this));
        } else if (client.getMiles() >= goldThreshold) {
            client.setStatus(new Platinum(this));
        }
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public String toString() {
        return "GOLD";
    }
}