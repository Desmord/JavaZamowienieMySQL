package controllers.order;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.OrderDao;
import dataClasess.OrderData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class OrderController implements Initializable {

	private OrderDao orderDao = new OrderDao();
	
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

				List<OrderData> lista = new ArrayList<OrderData>();

				lista = orderDao.findAll();
				
				for(OrderData obj: lista) {
					System.out.println("Id: "+obj.getId());
					System.out.println("Klient: "+obj.getCustomerId());
					System.out.println("Rabat klienta: "+obj.getDiscount());
					System.out.println("Koszt : "+obj.getTotalCost());
					System.out.println("-------------------------------");
				}
				
			}
		});

	}

}
