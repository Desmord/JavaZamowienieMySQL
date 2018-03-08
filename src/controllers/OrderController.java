package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class OrderController implements Initializable  {

    @FXML
    private AnchorPane orderPane;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("Inicjacja Zamowienia");
		
	}
	
	public void displayPane(boolean display) {
		orderPane.setVisible(display);
	}

}
