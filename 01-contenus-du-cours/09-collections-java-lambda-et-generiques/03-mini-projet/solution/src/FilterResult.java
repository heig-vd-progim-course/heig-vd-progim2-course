import java.util.List;

/**
 * Classe générique encapsulant le résultat d'un filtrage.
 *
 * @param <T> le type des éléments filtrés
 */
public class FilterResult<T> {
    private final List<T> matchingItems;
    private final int totalCount;
    private final String criteriaDescription;

    /**
     * Constructeur pour créer un résultat de filtrage.
     *
     * @param matchingItems les éléments correspondant au critère
     * @param totalCount le nombre total d'éléments testés
     * @param criteriaDescription la description du critère utilisé
     */
    public FilterResult(List<T> matchingItems, int totalCount,
            String criteriaDescription) {
        this.matchingItems = matchingItems;
        this.totalCount = totalCount;
        this.criteriaDescription = criteriaDescription;
    }

    /**
     * Retourne les éléments correspondant au critère.
     *
     * @return la liste des éléments
     */
    public List<T> getMatchingItems() {
        return matchingItems;
    }

    /**
     * Retourne le nombre d'éléments correspondant au critère.
     *
     * @return le nombre de correspondances
     */
    public int getMatchCount() {
        return matchingItems.size();
    }

    /**
     * Retourne le nombre total d'éléments testés.
     *
     * @return le nombre total
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Retourne la description du critère utilisé.
     *
     * @return la description du critère
     */
    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    /**
     * Affiche un résumé du filtrage.
     */
    public void displaySummary() {
        System.out.println("Filtrage : " + criteriaDescription);
        System.out.println("Résultat : " + getMatchCount()
                + "/" + totalCount + " élément(s).");
        for (T item : matchingItems) {
            System.out.println("  - " + item);
        }
    }
}
