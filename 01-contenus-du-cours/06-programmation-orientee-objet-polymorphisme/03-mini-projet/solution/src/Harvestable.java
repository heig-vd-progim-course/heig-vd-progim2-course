/**
 * Interface représentant une plante qui peut être récoltée.
 * Les classes qui implémentent cette interface doivent fournir
 * une méthode pour récolter la plante.
 */
public interface Harvestable {
    /**
     * Récolte la plante et retourne la quantité récoltée en kilogrammes.
     * 
     * @return la quantité récoltée en kg, ou 0 si la récolte n'est pas possible
     */
    double harvest();
    
    /**
     * Vérifie si la plante est prête à être récoltée.
     * 
     * @return true si la plante peut être récoltée, false sinon
     */
    boolean isReadyToHarvest();
}
