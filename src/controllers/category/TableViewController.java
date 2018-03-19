package controllers.category;

import java.net.URL;
import java.util.ResourceBundle;

import dataClasess.CategoryData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class TableViewController implements Initializable  {
	
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

}
