package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Descending cost
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        // Same cost: alphabetical title
        return String.CASE_INSENSITIVE_ORDER.compare(m1.getTitle(), m2.getTitle());
    }
}
