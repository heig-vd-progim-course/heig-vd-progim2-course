/**
 * Interface représentant une plante qui peut être arrosée.
 * Les classes qui implémentent cette interface doivent fournir
 * une méthode pour arroser la plante.
 */
public interface Waterable {
    /**
     * Arrose la plante avec une certaine quantité d'eau en litres.
     * 
     * @param liters la quantité d'eau en litres
     */
    void water(double liters);
    
    /**
     * Retourne la quantité d'eau nécessaire par semaine en litres.
     * 
     * @return la quantité d'eau recommandée en litres par semaine
     */
    double getWaterNeedsPerWeek();
}
