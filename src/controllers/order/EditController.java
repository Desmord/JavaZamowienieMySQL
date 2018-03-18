package controllers.order;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dataClasess.OrderData;
import interfaces.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EditController implements Initializable {

	private OrderData order = null;

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private TextField customerTextField;

	@FXML
	private TextField discountTextField;

	@FXML
	private TableView<Product> productTableView;

	@FXML
	private TableColumn<Product, String> nameTableCell;

	@FXML
	private TableColumn<Product, String> amountTableCell;

	@FXML
	private TableColumn<Product, String> priceTableCell;

	@FXML
	private Button addProductButton;

	@FXML
	private Button removeProductButton;

	@FXML
	private Label infoLabel;

	@FXML
	private Button saveButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setButtonClickEvetns();

	}

	public void displayPane(boolean display) {
		mainAnchorPane.setVisible(display);
		mainAnchorPane.toFront();
	}

	private void setButtonClickEvetns() {
		setAddProductButtonClickEvent();
		setRemoveProductButtonClickEvent();
		setSaveProductButtonClickEvent();
	}

	private void setAddProductButtonClickEvent() {
		addProductButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Dodawanie nowego produktu");
			}
		});
	}

	private void setRemoveProductButtonClickEvent() {
		removeProductButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("usuwanie starego produktu");
			}
		});
	}

	private void setSaveProductButtonClickEvent() {
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// tutaj sprawdzanie poprawnosci danych
				if (customerTextField.getText().equals("") || discountTextField.getText().equals("")) {
					infoLabel.setText("Wype³nij puste pola.");
				} else {
					infoLabel.setText("");
					OrderData editedOrder = new OrderData(order.getId(), Integer.parseInt(customerTextField.getText()),
							Integer.parseInt(discountTextField.getText()), order.getTotalCost());

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Zapisaæ zmiany?");
					alert.setTitle("Edycja zamówienia");
					alert.setHeaderText(null);

					ButtonType buttonTypeOne = new ButtonType("Tak");
					ButtonType buttonTypeTwo = new ButtonType("Nie");

					alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == buttonTypeOne) {
						infoLabel.setText("Zapisano zmiany.");
					}

				}
			}
		});
	}

	public void setOrder(OrderData order) {
		this.order = order;
	}

	public void setOrderData() {

		customerTextField.setText(Integer.toString(order.getCustomerId()));
		discountTextField.setText(Integer.toString(order.getDiscount()));

		// Tutaj lista produktow dodac do listy

	}

}
