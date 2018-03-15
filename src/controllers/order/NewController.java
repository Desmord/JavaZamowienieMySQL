package controllers.order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewController implements Initializable {

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

				System.out.println("Witaj swiece");

			}
		});

	}

}
