package AimsProject.hust.soict.ict.aims.screen;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.exception.PlayerException;
import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media, Cart cart, StoreScreen storeScreen) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        addToCartBtn.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(storeScreen,
                    "\"" + media.getTitle() + "\" has been added to your cart.",
                    "Added to Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        container.add(addToCartBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JDialog dialog = new JDialog(storeScreen, "Now Playing", true);
                    dialog.setLayout(new BorderLayout());
                    JLabel msg = new JLabel("<html><center>Now playing:<br><b>"
                            + media.getTitle() + "</b><br>Length: "
                            + (media instanceof AimsProject.hust.soict.ict.aims.media.Disc
                                ? ((AimsProject.hust.soict.ict.aims.media.Disc) media).getLength() + " mins"
                                : "") + "</center></html>",
                            SwingConstants.CENTER);
                    msg.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                    JButton ok = new JButton("OK");
                    ok.addActionListener(ev -> dialog.dispose());
                    dialog.add(msg, BorderLayout.CENTER);
                    dialog.add(ok, BorderLayout.SOUTH);
                    dialog.setSize(300, 180);
                    dialog.setLocationRelativeTo(storeScreen);
                    dialog.setVisible(true);
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(storeScreen,
                            ex.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
