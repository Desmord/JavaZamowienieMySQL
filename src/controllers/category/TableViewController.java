package controllers.category;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class TableViewController implements Initializable  {
	
	@FXML
	private AnchorPane mainAnchorPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Inicjacja kontrolera tablicy");
		
	}
	
	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);

	}

}
