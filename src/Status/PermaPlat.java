/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : PermaPlat.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019

 Remarque(s) :

 -----------------------------------------------------------------------------------
*/

package Status;

/**
 * Permanent platinum status
 */
class PermaPlat extends Platinum {
    PermaPlat(Status status) {
        super(status);
    }

    @Override
    public void thresholdCheck() {
        //empty so that no change can occur once this status is reached
    }
}
