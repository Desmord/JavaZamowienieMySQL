package controllers.product;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DAO.CategoryDao;
import DAO.ProductDao;
import dataClasess.CategoryData;
import dataClasess.ProductCategoryTableView;
import dataClasess.ProductData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TableController implements Initializable {

	ProductController productController;
	CategoryDao categoryDao = new CategoryDao();
	ProductDao productDao = new ProductDao();

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private TableView<ProductCategoryTableView> mainTableView;

	@FXML
	private TableColumn<ProductCategoryTableView, String> idCell;

	@FXML
	private TableColumn<ProductCategoryTableView, String> nameCell;

	@FXML
	private TableColumn<ProductCategoryTableView, String> priceCell;

	@FXML
	private TableColumn<ProductCategoryTableView, String> quantityCell;

	@FXML
	private TableColumn<ProductCategoryTableView, String> discountCell;

	@FXML
	private TableColumn<ProductCategoryTableView, String> categoryCell;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void displayPane(boolean display) {
		mainAnchorPane.setVisible(display);
	}

	/**
	 * Displays data in the table
	 * 
	 * @param list
	 *            of orders
	 */
	public void displayOrdersList() {

		List<ProductData> productList = productDao.findAll();
		List<CategoryData> categoryList = categoryDao.findAll();
		final ObservableList<ProductCategoryTableView> data = FXCollections.observableArrayList();

		for (int i = 0; i < productList.size(); i++) {
			data.add(new ProductCategoryTableView(productList.get(i).getId(), productList.get(i).getName(),
					productList.get(i).getPrice(), productList.get(i).getQuantity(), productList.get(i).getDiscount(),
					categoryDao.getCategoryName(productList.get(i).getCategoryId())));
		}
		
		idCell.setCellValueFactory(new PropertyValueFactory<ProductCategoryTableView, String>("id"));
		nameCell.setCellValueFactory(new PropertyValueFactory<ProductCategoryTableView, String>("name"));
		priceCell.setCellValueFactory(new PropertyValueFactory<ProductCategoryTableView, String>("price"));
		quantityCell.setCellValueFactory(new PropertyValueFactory<ProductCategoryTableView, String>("quantity"));
		discountCell.setCellValueFactory(new PropertyValueFactory<ProductCategoryTableView, String>("discount"));
		categoryCell.setCellValueFactory(new PropertyValueFactory<ProductCategoryTableView, String>("categoryName"));

		mainTableView.setItems(data);
	}

	public TableView<ProductCategoryTableView> getMainTableView() {
		return mainTableView;
	}

	public void setMainTableView(TableView<ProductCategoryTableView> mainTableView) {
		this.mainTableView = mainTableView;
	}

}
