package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class ProductController  implements Initializable  {

    @FXML
    private AnchorPane productPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("Inicjacja Produktu");
		
	}
	public void displayPane(boolean display) {
		productPane.setVisible(display);
	}
}
