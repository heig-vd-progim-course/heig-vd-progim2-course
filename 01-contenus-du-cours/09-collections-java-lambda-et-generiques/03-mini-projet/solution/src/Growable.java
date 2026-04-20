/**
 * Interface représentant une plante qui peut grandir.
 * Les classes qui implémentent cette interface doivent fournir
 * des méthodes pour gérer la croissance.
 */
public interface Growable {
    /**
     * Fait grandir la plante d'un certain nombre de centimètres.
     * 
     * @param centimeters la croissance en centimètres
     */
    void grow(double centimeters);
    
    /**
     * Retourne le taux de croissance moyen par semaine en centimètres.
     * 
     * @return le taux de croissance en cm par semaine
     */
    double getGrowthRate();
}
