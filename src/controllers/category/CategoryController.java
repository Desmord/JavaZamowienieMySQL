package controllers.category;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.CategoryDao;
import dataClasess.CategoryData;
import dataClasess.OrderData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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

	@FXML
	private Button showCategoryButton;

	@FXML
	private Button searchCategoryButton;

	@FXML
	private Button addCategoryButton;

	@FXML
	private Button editCategoryButton;

	@FXML
	private Button removeCategoryButton;

	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hideAllMinorPanes();
		tableCategoryController.displayPane(true);
		setButtonsEvetns();
		searchCategoryController.setMainCateogryController(this);
	}

	public void displayPane(boolean display) {
		categoryPane.setVisible(display);
	}

	public void hideAllMinorPanes() {
		tableCategoryController.displayPane(false);
		newCategoryController.displayPane(false);
		editCategoryController.displayPane(false);
		searchCategoryController.displayPane(false);
	}

	private void setButtonsEvetns() {
		setShowCategoryClickEvent();
		setSearchCategoryButtonClickEvent();
		setAddCategoryButtonClickEvent();
		setEditCategoryButtonClickEvent();
		setRemoveCategoryButtonClickEvent();
	}

	private void setRemoveCategoryButtonClickEvent() {
		removeCategoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				infoLabel.setText("");
				try {					
					CategoryData category = tableCategoryController.getMainTableView().getSelectionModel().getSelectedItem();

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Chcesz kategorie o nazwie: " + category.getName());
					alert.setTitle("Usuwanie kategorii");
					alert.setHeaderText(null);

					ButtonType buttonTypeOne = new ButtonType("Tak");
					ButtonType buttonTypeTwo = new ButtonType("Nie");

					alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == buttonTypeOne) {

						categoryDao.deleteCategory(category.getId());

						infoLabel.setText("Kategoria o numerze: " + category.getId() + " usuniêto poprawnie.");

						tableCategoryController.displayOrdersList(categoryDao.findAll());
					}

				} catch (NullPointerException e) {

					infoLabel.setText("Nie zaznaczono ¿adnego elementu.");

				}
			}
		});
	}

	private void setEditCategoryButtonClickEvent() {
		editCategoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				hideAllMinorPanes();
				editCategoryController.displayPane(true);
			}
		});
	}

	private void setAddCategoryButtonClickEvent() {
		addCategoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				hideAllMinorPanes();
				newCategoryController.displayPane(true);
			}
		});
	}

	private void setShowCategoryClickEvent() {
		showCategoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {				
				infoLabel.setText("");				
				hideAllMinorPanes();
				
				tableCategoryController.displayPane(true);				
				tableCategoryController.displayOrdersList(categoryDao.findAll());
			}
		});
	}

	private void setSearchCategoryButtonClickEvent() {
		searchCategoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				hideAllMinorPanes();
				searchCategoryController.displayPane(true);
			}
		});
	}

	public TableViewController getTableCategoryController() {
		return tableCategoryController;
	}

	public void setTableCategoryController(TableViewController tableCategoryController) {
		this.tableCategoryController = tableCategoryController;
	}

}
