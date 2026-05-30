package AimsProject.hust.soict.ict.aims.screen;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JDialog {
    protected Store store;
    protected Cart cart;
    protected StoreScreen storeScreen;

    public AddItemToStoreScreen(Store store, Cart cart, StoreScreen storeScreen, String title) {
        super(storeScreen, title, true);
        this.store = store;
        this.cart = cart;
        this.storeScreen = storeScreen;
    }

    protected JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        return panel;
    }

    protected GridBagConstraints labelConstraint(int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 10);
        return gbc;
    }

    protected GridBagConstraints fieldConstraint(int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        return gbc;
    }

    protected JPanel createButtonPanel(JButton okBtn) {
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dispose());
        btnPanel.add(cancelBtn);
        btnPanel.add(okBtn);
        return btnPanel;
    }

    protected void finishAndRefresh() {
        storeScreen.refreshStore();
        dispose();
    }
}
