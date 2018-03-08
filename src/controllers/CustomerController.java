package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class CustomerController implements Initializable  {

    @FXML
    private AnchorPane customaerPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("Inicjacja Klienta");
		
	}
	
	public void displayPane(boolean display) {
		customaerPane.setVisible(display);
	}
}
