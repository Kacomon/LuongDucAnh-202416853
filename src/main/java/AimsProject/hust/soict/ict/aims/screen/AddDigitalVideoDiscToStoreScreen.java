package AimsProject.hust.soict.ict.aims.screen;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfTitle    = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfCost     = new JTextField(20);
    private JTextField tfLength   = new JTextField(20);
    private JTextField tfDirector = new JTextField(20);

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart, StoreScreen storeScreen) {
        super(store, cart, storeScreen, "Add DVD");

        JPanel form = createFormPanel();
        form.add(new JLabel("Title:"),    labelConstraint(0));
        form.add(tfTitle,                 fieldConstraint(0));
        form.add(new JLabel("Category:"), labelConstraint(1));
        form.add(tfCategory,              fieldConstraint(1));
        form.add(new JLabel("Cost:"),     labelConstraint(2));
        form.add(tfCost,                  fieldConstraint(2));
        form.add(new JLabel("Length (mins):"), labelConstraint(3));
        form.add(tfLength,                fieldConstraint(3));
        form.add(new JLabel("Director:"), labelConstraint(4));
        form.add(tfDirector,              fieldConstraint(4));

        JButton addBtn = new JButton("Add DVD");
        addBtn.addActionListener(e -> addDVD());

        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(createButtonPanel(addBtn), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(storeScreen);
        setVisible(true);
    }

    private void addDVD() {
        try {
            String title    = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            double cost     = Double.parseDouble(tfCost.getText().trim());
            int length      = Integer.parseInt(tfLength.getText().trim());
            String director = tfDirector.getText().trim();

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD \"" + title + "\" added to store!");
            finishAndRefresh();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
