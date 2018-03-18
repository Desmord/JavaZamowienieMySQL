package controllers.order;

import java.net.URL;
import java.util.ResourceBundle;

import dataClasess.OrderData;
import interfaces.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

				System.out.println("zapisywanie");

			}
		});

	}

	public void setOrder(OrderData order) {
		this.order = order;
	}

	public void setOrderData() {
		System.out.println("Witaj swiecie");
	}

}
