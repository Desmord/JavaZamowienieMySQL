package controllers.order;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EditController implements Initializable {

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private TextField customerTextField;

	@FXML
	private TextField discountTextField;

	@FXML
	private TableView<Product> productTableView;

	@FXML
	private TableColumn<Product, String> nameTableCell;

	@FXML
	private TableColumn<Product, String> amountTableCell;

	@FXML
	private TableColumn<Product, String> priceTableCell;

	@FXML
	private Button addProductButton;

	@FXML
	private Button removeProductButton;

	@FXML
	private Label infoLabel;

	@FXML
	private Button saveButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("Inicjacja edycji zamowianie");
		
		
	}

	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);

	}

}
