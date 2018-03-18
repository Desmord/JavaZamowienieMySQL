package controllers.category;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.CategoryDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class CategoryController implements Initializable {

	CategoryDao categoryDao = new CategoryDao();
	
	@FXML
	private AnchorPane categoryPane;

	@FXML
	private EditController editCategoryController;
	
	@FXML
	private NewController newCategoryController;
	
	@FXML
	private SearchController searchCategoryController;
	
	@FXML
	private TableViewController tableCategoryController;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Inicjacja Kategori");

	}

	public void displayPane(boolean display) {
		categoryPane.setVisible(display);
	}
}
