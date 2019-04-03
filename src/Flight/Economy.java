/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Economy.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019

 Remarque(s) :

 -----------------------------------------------------------------------------------
*/

package Flight;

/**
 * Economy class ticket
 */
public class Economy extends Ticket {
    public Economy(Flight flight) {
        super(flight);

        setMoneyCoefficient(1);
        setMilesCoefficient(1);
    }
}