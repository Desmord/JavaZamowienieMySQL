package controllers.category;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DAO.CategoryDao;
import dataClasess.CategoryData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
				System.out.println("Usun");
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

				
//				List<CategoryData> lista = categoryDao.findAll();
//		
//				for(CategoryData cat: lista) {
//					System.out.println(cat.getId()+" nazwa: "+cat.getName());
//				}
				
//				List<CategoryData> lista = categoryDao.findById(6);
//		
//				for(CategoryData cat: lista) {
//					System.out.println(cat.getId()+" nazwa: "+cat.getName());
//				}
//				
//				List<CategoryData> lista = categoryDao.findByName("Owoc");
//		
//				for(CategoryData cat: lista) {
//					System.out.println(cat.getId()+" nazwa: "+cat.getName());
//				}
				
//				CategoryData obj = new CategoryData(6,"cosik2");
				
//				System.out.println(categoryDao.insertCategory(obj));
//				System.out.println(categoryDao.updateCategory(6, obj));
//				System.out.println(categoryDao.deleteCategory(6));
//				
//				List<Integer> lisa = categoryDao.getAllId();
//				
//				for(int f: lisa) {
//					System.out.println(f);
//				}
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

}
