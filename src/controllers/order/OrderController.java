package controllers.order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class OrderController implements Initializable {

	@FXML
	private TableViewController orderTableController;

	@FXML
	private NewController newOrderController;

	@FXML
	private EditController editOrderController;

	@FXML
	private SearchController searchOrderController;

	@FXML
	private AnchorPane orderPane;

	@FXML
	private Button showOrdersButton;

	@FXML
	private Button searchButton;

	@FXML
	private Button insertButton;

	@FXML
	private Button editButton;

	@FXML
	private Button deleteButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Inicjacja Zamowienia");

		hideAllMinorPanes();
		
		orderTableController.displayTable(true);

	}

	public void displayPane(boolean display) {

		orderPane.setVisible(display);

	}

	private void hideAllMinorPanes() {

		orderTableController.displayTable(false);
		newOrderController.displayPane(false);
		editOrderController.displayPane(false);
		searchOrderController.displayPane(false);

	}

}
