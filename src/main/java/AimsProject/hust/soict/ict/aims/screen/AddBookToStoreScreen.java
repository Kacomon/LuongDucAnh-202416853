package AimsProject.hust.soict.ict.aims.screen;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfTitle    = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfCost     = new JTextField(20);
    private JTextField tfAuthors  = new JTextField(20);

    public AddBookToStoreScreen(Store store, Cart cart, StoreScreen storeScreen) {
        super(store, cart, storeScreen, "Add Book");

        JPanel form = createFormPanel();
        form.add(new JLabel("Title:"),    labelConstraint(0));
        form.add(tfTitle,                 fieldConstraint(0));
        form.add(new JLabel("Category:"), labelConstraint(1));
        form.add(tfCategory,              fieldConstraint(1));
        form.add(new JLabel("Cost:"),     labelConstraint(2));
        form.add(tfCost,                  fieldConstraint(2));
        form.add(new JLabel("Authors\n(comma-separated):"), labelConstraint(3));
        form.add(tfAuthors,               fieldConstraint(3));

        JButton addBtn = new JButton("Add Book");
        addBtn.addActionListener(e -> addBook());

        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(createButtonPanel(addBtn), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(storeScreen);
        setVisible(true);
    }

    private void addBook() {
        try {
            String title    = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            double cost     = Double.parseDouble(tfCost.getText().trim());
            String authorsStr = tfAuthors.getText().trim();
            String[] authors = authorsStr.isEmpty() ? new String[0] : authorsStr.split(",");
            for (int i = 0; i < authors.length; i++) authors[i] = authors[i].trim();

            Book book = new Book(title, category, cost, authors);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book \"" + title + "\" added to store!");
            finishAndRefresh();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid cost value!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
