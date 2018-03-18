package controllers.category;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class CategoryController implements Initializable {

	@FXML
	private AnchorPane categoryPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Inicjacja Kategori");

	}

	public void displayPane(boolean display) {
		categoryPane.setVisible(display);
	}
}
