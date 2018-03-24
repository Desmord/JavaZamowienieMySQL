package controllers.product;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchController implements Initializable {

	ProductController productController;

	@FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private CheckBox idNumberCheckBox;

    @FXML
    private CheckBox nameCheckBox;

    @FXML
    private CheckBox categoryCheckBox;

    @FXML
    private TextField mainTextField;

    @FXML
    private Button showCategoryButton;

    @FXML
    private Button searchButton;

    @FXML
    private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("Inicjacja kontroleara wyszukiania produktu");
	}

	public void setMainProductController(ProductController productController) {
		this.productController = productController;
	}

	public void displayPane(boolean display) {
		mainAnchorPane.setVisible(display);
	}
}
