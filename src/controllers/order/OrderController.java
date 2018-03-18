package controllers.order;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.OrderDao;
import dataClasess.OrderData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class OrderController implements Initializable {

	private OrderDao orderDao = new OrderDao();

	@FXML
	private Label infoLabel;

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

		hideAllMinorPanes();

		orderTableController.displayTable(true);

		setButtonsEvetns();

		searchOrderController.setMainOrderController(this);

	}

	public void displayPane(boolean display) {

		orderPane.setVisible(display);

	}

	public void hideAllMinorPanes() {

		orderTableController.displayTable(false);
		newOrderController.displayPane(false);
		editOrderController.displayPane(false);
		searchOrderController.displayPane(false);

	}

	private void setButtonsEvetns() {

		setShowOrderButtonClickEvent();
		setSearchOrderButtonClickEvent();
		setNewOrderButtonClickEvent();
		setEditOrderButtonClickEvent();
		setDeleteOrderButtonClickEvent();

	}

	private void setShowOrderButtonClickEvent() {

		showOrdersButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				infoLabel.setText("");

				hideAllMinorPanes();
				orderTableController.displayTable(true);

				orderTableController.displayOrdersList(orderDao.findAll());

			}
		});

	}

	private void setSearchOrderButtonClickEvent() {

		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				infoLabel.setText("");

				hideAllMinorPanes();
				searchOrderController.displayPane(true);

			}
		});

	}

	private void setNewOrderButtonClickEvent() {

		insertButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				infoLabel.setText("");

				hideAllMinorPanes();
				newOrderController.displayPane(true);

			}
		});

	}

	private void setEditOrderButtonClickEvent() {

		editButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				try {

					OrderData order = orderTableController.getOrderTableView().getSelectionModel().getSelectedItem();

					if (order != null) {

						editOrderController.setOrder(order);
						editOrderController.setOrderData();
						
						infoLabel.setText("");
						
						hideAllMinorPanes();
						editOrderController.displayPane(true);

					} else {
						infoLabel.setText("Nie zaznaczono ¿adnego elementu.");
					}

				} catch (NullPointerException e) {
					infoLabel.setText("Nie zaznaczono ¿adnego elementu.");
				}

			}
		});

	}

	private void setDeleteOrderButtonClickEvent() {

		deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				infoLabel.setText("");

				try {

					OrderData order = orderTableController.getOrderTableView().getSelectionModel().getSelectedItem();

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Chcesz usun¹æ zamówienie o numerze: " + order.getId());
					alert.setTitle("Usuwanie zamówienia");
					alert.setHeaderText(null);

					ButtonType buttonTypeOne = new ButtonType("Tak");
					ButtonType buttonTypeTwo = new ButtonType("Nie");

					alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == buttonTypeOne) {

						orderDao.deleteProduct(order.getId());

						infoLabel.setText("Zamowienie o numerze: " + order.getId() + " usuniêto poprawnie.");

						orderTableController.displayOrdersList(orderDao.findAll());
					}

				} catch (NullPointerException e) {

					infoLabel.setText("Nie zaznaczono ¿adnego elementu.");

				}

			}
		});

	}

	public TableViewController getOrderTableController() {
		return orderTableController;
	}

	public void setOrderTableController(TableViewController orderTableController) {
		this.orderTableController = orderTableController;
	}

}
