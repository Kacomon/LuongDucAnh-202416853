package AimsProject.hust.soict.ict.aims.screen;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.Track;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfTitle    = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfCost     = new JTextField(20);
    private JTextField tfDirector = new JTextField(20);
    private JTextField tfArtist   = new JTextField(20);
    private JTextArea  taTrack    = new JTextArea(4, 20);

    public AddCompactDiscToStoreScreen(Store store, Cart cart, StoreScreen storeScreen) {
        super(store, cart, storeScreen, "Add CD");

        JPanel form = createFormPanel();
        form.add(new JLabel("Title:"),    labelConstraint(0));
        form.add(tfTitle,                 fieldConstraint(0));
        form.add(new JLabel("Category:"), labelConstraint(1));
        form.add(tfCategory,              fieldConstraint(1));
        form.add(new JLabel("Cost:"),     labelConstraint(2));
        form.add(tfCost,                  fieldConstraint(2));
        form.add(new JLabel("Director:"), labelConstraint(3));
        form.add(tfDirector,              fieldConstraint(3));
        form.add(new JLabel("Artist:"),   labelConstraint(4));
        form.add(tfArtist,                fieldConstraint(4));

        JLabel trackLabel = new JLabel("<html>Tracks<br>(title,length per line):</html>");
        form.add(trackLabel, labelConstraint(5));
        taTrack.setLineWrap(true);
        taTrack.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taTrack.setToolTipText("Format: TrackName,length\nExample: Song1,180");
        form.add(new JScrollPane(taTrack), fieldConstraint(5));

        JButton addBtn = new JButton("Add CD");
        addBtn.addActionListener(e -> addCD());

        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(createButtonPanel(addBtn), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(storeScreen);
        setVisible(true);
    }

    private void addCD() {
        try {
            String title    = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            double cost     = Double.parseDouble(tfCost.getText().trim());
            String director = tfDirector.getText().trim();
            String artist   = tfArtist.getText().trim();

            CompactDisc cd = new CompactDisc(title, category, cost, director, artist);

            // Parse tracks: each line is "trackTitle,length"
            String[] lines = taTrack.getText().split("\n");
            for (String line : lines) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String trackTitle = parts[0].trim();
                        int trackLength = Integer.parseInt(parts[1].trim());
                        cd.addTrack(new Track(trackTitle, trackLength));
                    }
                }
            }

            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD \"" + title + "\" added to store!");
            finishAndRefresh();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
