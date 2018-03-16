package controllers.order;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DAO.OrderDao;
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

				System.out.println(getFreeIndex());

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

}
