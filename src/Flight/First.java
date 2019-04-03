/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : First.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019
 -----------------------------------------------------------------------------------
*/

package Flight;

/**
 * First class ticket
 */
public class First extends Ticket {
    public First(Flight flight) {
        super(flight);

        setMoneyCoefficient(5);
        setMilesCoefficient(30);
    }
}