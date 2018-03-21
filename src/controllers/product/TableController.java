package controllers.product;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class TableController implements Initializable {

	ProductController productController;

	@FXML
	private AnchorPane mainAnchorPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("Inicjacja kontrolera tablicy produktu");
	}

	public void displayPane(boolean display) {
		mainAnchorPane.setVisible(display);
	}

}
