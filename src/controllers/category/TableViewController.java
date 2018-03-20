package controllers.category;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dataClasess.CategoryData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TableViewController implements Initializable  {
	
	@FXML
	private TableView<CategoryData> mainTableView;
	
	@FXML
	private AnchorPane mainAnchorPane;

    @FXML
    private TableColumn<CategoryData, String> idTableCell;

    @FXML
    private TableColumn<CategoryData, String> nameTableCell;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Inicjacja kontrolera tablicy");
		
	}
	
	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);

	}

	public void displayTable(boolean display) {
		mainTableView.setVisible(display);
	}
	
	/**
	 * Displays data in the table
	 * @param list of orders
	 */
	public void displayOrdersList(List<CategoryData> list) {

		final ObservableList<CategoryData> data = FXCollections.observableArrayList();

		for (CategoryData obj : list) {
			data.add(new CategoryData(obj.getId(),obj.getName()));
		}
		
		idTableCell.setCellValueFactory(new PropertyValueFactory<CategoryData, String>("id"));
		nameTableCell.setCellValueFactory(new PropertyValueFactory<CategoryData, String>("name"));

		mainTableView.setItems(data);
	}
	
}
