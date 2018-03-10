package controllers.order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class NewController implements Initializable {

	@FXML
	private AnchorPane mainAnchorPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Inicjacja nowy produkt pane");

	}

	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);

	}

}
