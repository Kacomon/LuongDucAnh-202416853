package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleCompare = String.CASE_INSENSITIVE_ORDER.compare(m1.getTitle(), m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        // Same title: higher cost first (descending)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
