package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator
            .comparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER)
            .thenComparing(Comparator.comparing(Media::getCost).reversed());

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator
            .comparing(Media::getCost).reversed()
            .thenComparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER);

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;
        if (title == null) {
            return other.title == null;
        }
        return title.equalsIgnoreCase(other.title);
    }

    @Override
    public int hashCode() {
        return title == null ? 0 : title.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
    }
}
