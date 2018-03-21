package controllers.product;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.ProductDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ProductController implements Initializable {

	private ProductDao productDao = new ProductDao();

	@FXML
	private Label infoLabel;

	@FXML
	private EditController editProductController;

	@FXML
	private NewController newProductController;

	@FXML
	private SearchController searcProductController;

	@FXML
	private TableController productTableController;

	@FXML
	private AnchorPane productPane;

	@FXML
	private Button showAllButton;

	@FXML
	private Button searchButton;

	@FXML
	private Button newButton;

	@FXML
	private Button editButton;

	@FXML
	private Button removeButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hideAllMinorPanes();

		productTableController.displayPane(true);

		setButtonsEvents();

		searcProductController.setMainProductController(this);
	}

	public void hideAllMinorPanes() {
		editProductController.displayPane(false);
		newProductController.displayPane(false);
		searcProductController.displayPane(false);
		productTableController.displayPane(false);
	}

	public void displayPane(boolean display) {
		productPane.setVisible(display);
	}

	private void setButtonsEvents() {
		setShowAllButtonClickEvent();
		setSearchButtonClickEvent();
		setNewButtonClickEvent();
		setEditButtonClickEvent();
		setRemoveButtonClickEvent();
	}

	private void setRemoveButtonClickEvent() {
		removeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {


				
				
				
				
			}
		});
	}

	private void setEditButtonClickEvent() {
		editButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				hideAllMinorPanes();
				editProductController.displayPane(true);
			}
		});
	}

	private void setNewButtonClickEvent() {
		newButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				hideAllMinorPanes();
				newProductController.displayPane(true);
			}
		});
	}

	private void setShowAllButtonClickEvent() {
		showAllButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				hideAllMinorPanes();
				productTableController.displayPane(true);
			}
		});
	}

	private void setSearchButtonClickEvent() {
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				hideAllMinorPanes();
				searcProductController.displayPane(true);
			}
		});
	}
}
