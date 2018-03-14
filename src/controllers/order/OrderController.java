package controllers.order;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DAO.OrderDao;
import dataClasess.OrderData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

				hideAllMinorPanes();
				orderTableController.displayTable(true);

			}
		});

	}

	private void setSearchOrderButtonClickEvent() {

		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				hideAllMinorPanes();
				searchOrderController.displayPane(true);

			}
		});

	}

	private void setNewOrderButtonClickEvent() {

		insertButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				hideAllMinorPanes();
				newOrderController.displayPane(true);

			}
		});

	}

	private void setEditOrderButtonClickEvent() {

		editButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				hideAllMinorPanes();
				editOrderController.displayPane(true);

			}
		});

	}

	private void setDeleteOrderButtonClickEvent() {

		deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Usuwanie");

				List<OrderData> list = orderDao.findByCustomerId(2);

				if (list.size() == 0) {
					infoLabel.setText("Nie znaleziono ¿andnych elementów.");

				} else {
					infoLabel.setText("");

					// Wyszukianie wszystkich
					// orderTableController.displayOrdersList(orderDao.findAll());

					// Wyszukiwanie po id
					// orderTableController.displayOrdersList(orderDao.findById(2));

					// Wyszukiwanie po idKlienta
					// orderTableController.displayOrdersList(findByCustomerId(2));

					// Wstawianie danych
					// orderDao.insertProduct(new OrderData(4,2,0,"0"));

					// Uaktualnianie danych
					// orderDao.updateProduct(4, new OrderData(4,1,0,"0"));

					// Usuwanie danych
					// orderDao.deleteProduct(3);

				}
			}
		});

	}

}
