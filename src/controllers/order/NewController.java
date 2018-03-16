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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewController implements Initializable {

	private OrderDao orderDao = new OrderDao();

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private TextField customerNameTextField;

	@FXML
	private TextField discountTextField;

	@FXML
	private Button addButton;

	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setAddButtonClickEvent();

	}

	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);
		mainAnchorPane.toFront();

	}

	private void setAddButtonClickEvent() {

		addButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				if (discountTextField.getText().equals("") || customerNameTextField.getText().equals("")) {

					infoLabel.setText("Nie wprowadzono wszystkich danych.");
					
				} else {

					if (isNumber(discountTextField)) {

						OrderData order = new OrderData(getFreeIndex(),
								Integer.parseInt(customerNameTextField.getText()),
								Integer.parseInt(discountTextField.getText()), 0 + "");

						orderDao.insertProduct(order);

						infoLabel.setText("Dodawanie przebieg³o poprawnie.");

					} else {

						infoLabel.setText("Rabat musi byæ liczb¹");

					}
				}
			}
		});

	}

	private int getFreeIndex() {

		List<Integer> lista = orderDao.getAllId();

		for (int i = 1; i < lista.size() + 1; i++) {

			if (i != lista.get(i - 1)) {

				return i;

			}
		}

		return lista.size() + 1;
	}

	private boolean isNumber(TextField field) {

		String text = field.getText();

		for (int i = 0; i < text.length(); i++) {

			if (!text.substring(i, i + 1).matches("[0-9]")) {
				return false;
			}

		}

		return true;
	}

}
