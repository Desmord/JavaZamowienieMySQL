package controllers.product;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.CategoryDao;
import DAO.ProductDao;
import dataClasess.CategoryData;
import dataClasess.ProductCategoryTableView;
import dataClasess.ProductData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchController implements Initializable {

	ProductController productController;
	ProductDao productDao = new ProductDao();
	CategoryDao categoryDao = new CategoryDao();

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
	private Button searchButton;

	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setElementsClickEvents();
	}

	private void setElementsClickEvents() {
		setIdNumberChcekBoxClickEvent();
		setNameCheckBoxClickEvent();
		setCategoryChcekBoxClickEvent();
		setSearchButtonClickEvent();
	}

	private void setSearchButtonClickEvent() {
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				infoLabel.setText("");

				if (!mainTextField.getText().equals("")) {
					if (idNumberCheckBox.isSelected()) {
						searchId();
					} else if (nameCheckBox.isSelected()) {
						searchName();
					} else if (categoryCheckBox.isSelected()) {
						searchCategory();
					} else {
						infoLabel.setText("Zaznacz opcjê wyszukiwania.");
					}
				} else {
					infoLabel.setText("Wpisz wartoœæ do wyszukania.");
				}
			}
		});
	}

	private void searchId() {
		if (isNumber()) {
			List<ProductData> product = productDao.findById(Integer.parseInt(mainTextField.getText()));
			if (product.size() == 0) {
				infoLabel.setText("Nieznaleziono produktu");
			} else {
				List<CategoryData> category = categoryDao.findById(product.get(0).getCategoryId());

				if (category.size() == 0) {
					infoLabel.setText("Nie znaleziono ¿adnego produktu.");
				} else {
					ProductCategoryTableView TCTV = new ProductCategoryTableView(product.get(0).getId(),
							product.get(0).getName(), product.get(0).getPrice(), product.get(0).getQuantity(),
							product.get(0).getDiscount(), category.get(0).getName());

					productController.getProductTableController().displayGivenOrdersList(TCTV);
					productController.hideAllMinorPanes();
					productController.getProductTableController().displayPane(true);
				}
			}
		}
	}

	private boolean isNumber() {
		String text = mainTextField.getText();
		for (int i = 0; i < text.length(); i++) {
			if (!text.substring(i, i + 1).matches("[0-9]")) {
				return false;
			}
		}
		return true;
	}

	private void searchName() {
		List<ProductData> product = productDao.findByName(mainTextField.getText());
		if (product.size() == 0) {
			infoLabel.setText("Nie znaleziono ¿adnego produktu.");
		} else {
			List<CategoryData> category = categoryDao.findById(product.get(0).getCategoryId());

			if (category.size() == 0) {
				infoLabel.setText("Nie znaleziono ¿adnego produktu.");
			} else {
				ProductCategoryTableView TCTV = new ProductCategoryTableView(product.get(0).getId(),
						product.get(0).getName(), product.get(0).getPrice(), product.get(0).getQuantity(),
						product.get(0).getDiscount(), category.get(0).getName());

				productController.getProductTableController().displayGivenOrdersList(TCTV);
				productController.hideAllMinorPanes();
				productController.getProductTableController().displayPane(true);
			}
		}

	}

	private void searchCategory() {

		List<CategoryData> categoryList = categoryDao.findByName(mainTextField.getText());

		if (categoryList.size() == 0) {
			infoLabel.setText("Nie znaleziono ¿adnej kategori");
		} else {
			List<ProductData> productList = productDao.findByCategory(categoryList.get(0).getId());

			if (productList.size() == 0) {
				infoLabel.setText("Nie znaleziono ¿adnej kategori");
			} else {
				List<ProductCategoryTableView> list = new ArrayList<ProductCategoryTableView>();

				for (ProductData obj : productList) {
					list.add(new ProductCategoryTableView(obj.getId(), obj.getName(), obj.getPrice(), obj.getQuantity(),
							obj.getDiscount(),categoryList.get(0).getName()));
				}
				
				productController.getProductTableController().displayGivenProductList(list);
				productController.hideAllMinorPanes();
				productController.getProductTableController().displayPane(true);
			}
		}

	}

	private void setCategoryChcekBoxClickEvent() {
		categoryCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				nameCheckBox.setSelected(false);
				idNumberCheckBox.setSelected(false);
			}
		});
	}

	private void setNameCheckBoxClickEvent() {
		nameCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				categoryCheckBox.setSelected(false);
				idNumberCheckBox.setSelected(false);
			}
		});
	}

	private void setIdNumberChcekBoxClickEvent() {
		idNumberCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				nameCheckBox.setSelected(false);
				categoryCheckBox.setSelected(false);
			}
		});
	}

	public void setMainProductController(ProductController productController) {
		this.productController = productController;
	}

	public void displayPane(boolean display) {
		mainAnchorPane.setVisible(display);
	}
}
