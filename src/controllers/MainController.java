package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.order.OrderController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainController implements Initializable {

	@FXML
	private CustomerController customerPaneController;

	@FXML
	private OrderController orderPaneController;

	@FXML
	private ProductController productPaneController;

	@FXML
	private CategoryController categoryPaneController;

	@FXML
	private Button orderButton;

	@FXML
	private Button customerButton;

	@FXML
	private Button productButton;

	@FXML
	private Button categoryButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setButtonsEvents();

		hideAllMinorPanes();
		
		orderPaneController.displayPane(true);

	}

	private void setButtonsEvents() {

		setOrderButtonClickEvent();
		setCategoryButtonClickEvent();
		setProductButtonClickEvent();
		setCustomerButtonClickEvent();

	}

	private void setOrderButtonClickEvent() {

		orderButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				hideAllMinorPanes();
				orderPaneController.displayPane(true);

			}
		});

	}

	private void setCustomerButtonClickEvent() {

		customerButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				hideAllMinorPanes();
				customerPaneController.displayPane(true);

			}
		});

	}

	private void setProductButtonClickEvent() {

		productButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				hideAllMinorPanes();
				productPaneController.displayPane(true);

			}
		});

	}

	private void setCategoryButtonClickEvent() {

		categoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				hideAllMinorPanes();
				categoryPaneController.displayPane(true);

			}
		});

	}

	private void hideAllMinorPanes() {

		orderPaneController.displayPane(false);
		productPaneController.displayPane(false);
		categoryPaneController.displayPane(false);
		customerPaneController.displayPane(false);
		
	}

}
