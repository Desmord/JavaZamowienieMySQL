package controllers.order;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dataClasess.OrderData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController implements Initializable {

	@FXML
	private TableView<OrderData> orderTableView;

	@FXML
	private TableColumn<OrderData, String> orderNumberTableColumn;

	@FXML
	private TableColumn<ObservableList<String>, String> customerTableColumn;

	@FXML
	private TableColumn<ObservableList<String>, String> discountTableColumn;

	@FXML
	private TableColumn<ObservableList<String>, String> totalCostTableColumn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void displayTable(boolean display) {
		orderTableView.setVisible(display);
	}

	public void displayOrdersList(List<OrderData> list) {

		System.out.println("Wyœwietlanie listy");
		
		for (OrderData obj : list) {

			final ObservableList<OrderData> data = FXCollections.observableArrayList(
					// new Person("Jacob", "Smith", "jacob.smith@example.com"),
					// new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
					// new Person("Ethan", "Williams", "ethan.williams@example.com"),
					// new Person("Emma", "Jones", "emma.jones@example.com"),
					// new Person("Michael", "Brown", "michael.brown@example.com")
					new OrderData(obj.getId(), obj.getCustomerId(), obj.getDiscount(), obj.getTotalCost()));

			orderNumberTableColumn.setCellValueFactory(new PropertyValueFactory<OrderData, String>("id"));

			orderTableView.setItems(data);
			
			// System.out.println("Id: "+obj.getId());
			// System.out.println("Klient: "+obj.getCustomerId());
			// System.out.println("Rabat klienta: "+obj.getDiscount());
			// System.out.println("Koszt : "+obj.getTotalCost());
			// System.out.println("-------------------------------");

		}

	}

}
