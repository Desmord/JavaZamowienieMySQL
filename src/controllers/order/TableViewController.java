package controllers.order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class TableViewController implements Initializable {

	@FXML
	private TableView<?> orderTableView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("Generowanie tabeli zamowien");
		
	}
	
	public void displayTable(boolean display) {
		orderTableView.setVisible(display);
	}
}
