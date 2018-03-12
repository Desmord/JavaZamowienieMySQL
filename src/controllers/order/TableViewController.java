package controllers.order;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dataClasess.OrderData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableViewController implements Initializable {

	@FXML
	private TableView<?> orderTableView;

	@FXML
    private TableColumn<?, ?> orderNumberTableColumn;

    @FXML
    private TableColumn<?, ?> customerTableColumn;

    @FXML
    private TableColumn<?, ?> discountTableColumn;

    @FXML
    private TableColumn<?, ?> totalCostTableColumn;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("Generowanie tabeli zamowien");
		
	}
	
	public void displayTable(boolean display) {
		orderTableView.setVisible(display);
	}
	

	private void displayOrderList(List<OrderData> list) {
		System.out.println("Wysiwetlanie danych w tabeli");
	}
	
}
