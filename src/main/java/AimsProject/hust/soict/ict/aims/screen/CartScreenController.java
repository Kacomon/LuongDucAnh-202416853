package AimsProject.hust.soict.ict.aims.screen;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.exception.PlayerException;
import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.media.Playable;
import AimsProject.hust.soict.ict.aims.store.Store;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;
    private Store store;
    private StoreScreen storeScreen;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotal;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    public CartScreenController(Cart cart, Store store, StoreScreen storeScreen) {
        this.cart = cart;
        this.store = store;
        this.storeScreen = storeScreen;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ObservableList<Media> observableItems = FXCollections.observableArrayList(cart.getItemsOrdered());
        tblMedia.setItems(observableItems);

        updateTotal();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // ChangeListener for selected item
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<Media>) (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                });

        // ChangeListener for filter text
        if (tfFilter != null) {
            tfFilter.textProperty().addListener((obs, oldVal, newVal) -> showFilteredMedia(newVal));
        }
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void updateTotal() {
        if (lblTotal != null) {
            lblTotal.setText(String.format("%.2f $", cart.totalCost()));
        }
    }

    private void showFilteredMedia(String keyword) {
        ObservableList<Media> all = FXCollections.observableArrayList(cart.getItemsOrdered());
        if (keyword == null || keyword.isEmpty()) {
            tblMedia.setItems(all);
            return;
        }
        FilteredList<Media> filtered = new FilteredList<>(all);
        if (radioBtnFilterId != null && radioBtnFilterId.isSelected()) {
            try {
                int id = Integer.parseInt(keyword);
                filtered.setPredicate(m -> m.getId() == id);
            } catch (NumberFormatException e) {
                filtered.setPredicate(m -> false);
            }
        } else {
            filtered.setPredicate(m -> m.getTitle().toLowerCase().contains(keyword.toLowerCase()));
        }
        tblMedia.setItems(filtered);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
            updateTotal();
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            try {
                ((Playable) selected).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Now Playing");
                alert.setHeaderText("Now playing: " + selected.getTitle());
                alert.setContentText("Enjoy the media!");
                alert.showAndWait();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play Error");
                alert.setHeaderText("Cannot play media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText("Your cart is empty!");
            alert.showAndWait();
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Place Order");
        confirm.setHeaderText("Confirm order of " + cart.getItemsOrdered().size() + " item(s)");
        confirm.setContentText("Total: " + String.format("%.2f $", cart.totalCost()));
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                cart.empty();
                tblMedia.setItems(FXCollections.observableArrayList());
                updateTotal();
                btnPlay.setVisible(false);
                btnRemove.setVisible(false);
            }
        });
    }

    @FXML
    void menuViewStorePressed(ActionEvent event) {
        if (storeScreen != null) {
            storeScreen.refreshStore();
            storeScreen.toFront();
        }
    }

    @FXML
    void menuViewCartPressed(ActionEvent event) {
        // Already on cart screen
    }

    @FXML
    void menuAddBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, cart, storeScreen);
    }

    @FXML
    void menuAddCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, cart, storeScreen);
    }

    @FXML
    void menuAddDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, cart, storeScreen);
    }
}
