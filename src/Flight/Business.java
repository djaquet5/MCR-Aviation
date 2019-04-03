/*
 -----------------------------------------------------------------------------------
 Laboratoire : 02
 Fichier     : Business.java
 Auteur(s)   : David Jaquet & Yoann Rohrbasser
 Date        : 03.04.2019
 -----------------------------------------------------------------------------------
*/

package Flight;

/**
 * Business class ticket
 */
public class Business extends Ticket {
    public Business(Flight flight) {
        super(flight);

        setMoneyCoefficient(2);
        setMilesCoefficient(5);
    }
}