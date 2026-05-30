package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // swap() does NOT work — Java is pass-by-value
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap():");
        System.out.println("  jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("  cinderella dvd title: " + cinderellaDVD.getTitle());

        // swap2() WORKS — mutates fields via shared reference
        swap2(jungleDVD, cinderellaDVD);
        System.out.println("After swap2():");
        System.out.println("  jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("  cinderella dvd title: " + cinderellaDVD.getTitle());

        // changeTitle mutates via reference but reassigning dvd has no effect outside
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle():");
        System.out.println("  jungle dvd title: " + jungleDVD.getTitle());
    }

    // Does NOT swap — only swaps local copies of references
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // CORRECTLY swaps all fields of two DVDs
    public static void swap2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);

        String tmpCategory = dvd1.getCategory();
        dvd1.setCategory(dvd2.getCategory());
        dvd2.setCategory(tmpCategory);

        String tmpDirector = dvd1.getDirector();
        dvd1.setDirector(dvd2.getDirector());
        dvd2.setDirector(tmpDirector);

        int tmpLength = dvd1.getLength();
        dvd1.setLength(dvd2.getLength());
        dvd2.setLength(tmpLength);

        // NOTE: cost has no setter — omitted intentionally (final-like field)
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);            // modifies the actual object
        dvd = new DigitalVideoDisc(oldTitle); // local reassign, no effect outside
    }
}
