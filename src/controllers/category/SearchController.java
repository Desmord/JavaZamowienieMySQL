package controllers.category;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DAO.CategoryDao;
import controllers.order.OrderController;
import dataClasess.CategoryData;
import dataClasess.OrderData;
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

	CategoryDao categoryDao = new CategoryDao();
	CategoryController categoryController;

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private CheckBox idCheckBox;

	@FXML
	private CheckBox nameCheckBox;

	@FXML
	private TextField searchTextField;

	@FXML
	private Button searchButton;

	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setSearchButtonClickEvent();
		setCategoryIdCheckBoxClickEvent();
		setCategoryNameCheckBoxClickEvent();
	}

	public void displayPane(boolean display) {
		mainAnchorPane.setVisible(display);
		mainAnchorPane.toFront();
	}

	private void setSearchButtonClickEvent() {
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				infoLabel.setText("");

				if (isTextFieldEmpty()) {
					if (idCheckBox.isSelected()) {
						if (isNumber()) {
							List<CategoryData> list = categoryDao.findById(Integer.parseInt(searchTextField.getText()));

							if (list.size() == 0) {
								infoLabel.setText(
										"Nie znaleziono ¿adnej kateogrii o numerze: " + searchTextField.getText());
							} else {
								categoryController.hideAllMinorPanes();
								categoryController.getTableCategoryController().displayTable(true);
								categoryController.getTableCategoryController().displayPane(true);
								categoryController.getTableCategoryController().displayOrdersList(list);
							}
						} else {
							infoLabel.setText("Muszisz podaæ liczbê.");
						}
					} else if (nameCheckBox.isSelected()) {
						List<CategoryData> list = categoryDao.findByName(searchTextField.getText());

						if (list.size() == 0) {
							infoLabel.setText(
									"Nie znaleziono ¿adnej kategori o podanej nazwie: " + searchTextField.getText());
						} else {
							categoryController.hideAllMinorPanes();
							categoryController.getTableCategoryController().displayTable(true);
							categoryController.getTableCategoryController().displayPane(true);
							categoryController.getTableCategoryController().displayOrdersList(list);
						}
					}
				}else {
					infoLabel.setText("Nie wpisano ¿adnej wartoœci w pole tekstowe");
				}
			}
		});
	}

	private boolean isNumber() {

		String text = searchTextField.getText();

		for (int i = 0; i < text.length(); i++) {

			if (!text.substring(i, i + 1).matches("[0-9]")) {
				return false;
			}

		}

		return true;
	}

	private boolean isTextFieldEmpty() {

		if (searchTextField.getText().equals("")) {

			return false;

		}

		return true;
	}

	private void setCategoryIdCheckBoxClickEvent() {
		idCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				nameCheckBox.setSelected(false);
			}
		});
	}

	private void setCategoryNameCheckBoxClickEvent() {
		nameCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				idCheckBox.setSelected(false);
			}
		});
	}

	public void setMainCateogryController(CategoryController cateogryController) {
		this.categoryController = cateogryController;
	}
}
