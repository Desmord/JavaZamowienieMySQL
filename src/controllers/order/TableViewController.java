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
	private TableColumn<OrderData, String> customerTableColumn;

	@FXML
	private TableColumn<OrderData, String> discountTableColumn;

	@FXML
	private TableColumn<OrderData, String> totalCostTableColumn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void displayTable(boolean display) {
		orderTableView.setVisible(display);
	}

	
	/**
	 * Displays data in the table
	 * @param list of orders
	 */
	public void displayOrdersList(List<OrderData> list) {

		final ObservableList<OrderData> data = FXCollections.observableArrayList();

		for (OrderData obj : list) {

			data.add(new OrderData(obj.getId(), obj.getCustomerId(), obj.getDiscount(), obj.getTotalCost()));

		}

		orderNumberTableColumn.setCellValueFactory(new PropertyValueFactory<OrderData, String>("id"));
		customerTableColumn.setCellValueFactory(new PropertyValueFactory<OrderData, String>("customerId"));
		discountTableColumn.setCellValueFactory(new PropertyValueFactory<OrderData, String>("discount"));
		totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<OrderData, String>("totalCost"));

		orderTableView.setItems(data);

	}

	public TableView<OrderData> getOrderTableView() {
		return orderTableView;
	}

	public void setOrderTableView(TableView<OrderData> orderTableView) {
		this.orderTableView = orderTableView;
	}

}
