package controllers.product;

import java.net.URL;
import java.util.ResourceBundle;

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
		setElementsClickEvents();
	}

	private void setElementsClickEvents() {
		setIdNumberChcekBoxClickEvent();
		setNameCheckBoxClickEvent();
		setCategoryChcekBoxClickEvent();
		setSearchButtonClickEvent();
		setShowCategoryButtonClickEvent();
	}
	
	private void setSearchButtonClickEvent() {
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {				
				infoLabel.setText("");
				
				if(!mainTextField.getText().equals("")) {				
					if(idNumberCheckBox.isSelected()) {
						searchId();
					}else if(nameCheckBox.isSelected()) {
						searchName();
					}else if(categoryCheckBox.isSelected()) {
						searchCategory();
					}else {
						infoLabel.setText("Zaznacz opcjê wyszukiwania.");
					}	
				}else {
					infoLabel.setText("Wpisz wartoœæ do wyszukania.");
				}			
			}
		});
	}
	
	private void searchId() {
		System.out.println("id");
	}
	
	private void searchName() {
		System.out.println("nazwa");
	}
	
	private void searchCategory() {
		System.out.println("kategori");
	}

	private void setShowCategoryButtonClickEvent() {
		showCategoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("pokaz kateogri");
				
			}
		});
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
