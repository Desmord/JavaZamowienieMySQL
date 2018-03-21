package controllers.category;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.CategoryDao;
import dataClasess.CategoryData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EditController implements Initializable {

	private CategoryData category;
	private CategoryDao categoryDao = new CategoryDao();

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private TextField editTextField;

	@FXML
	private Button saveButton;

	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setSaveButtonClickEvent();
	}

	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);
		mainAnchorPane.toFront();
	}

	public void setCategoryData() {
		editTextField.setText(category.getName());
	}

	private void setSaveButtonClickEvent() {
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// tutaj sprawdzanie poprawnosci danych
				if (editTextField.getText().equals("")) {
					infoLabel.setText("Wype³nij puste pola.");
				} else {
					infoLabel.setText("");
					CategoryData editedCategory = new CategoryData(category.getId(), editTextField.getText());
					
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Zapisaæ zmiany?");
					alert.setTitle("Edycja kateogrii");
					alert.setHeaderText(null);

					ButtonType buttonTypeOne = new ButtonType("Tak");
					ButtonType buttonTypeTwo = new ButtonType("Nie");

					alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == buttonTypeOne) {
						categoryDao.updateCategory(editedCategory);
						infoLabel.setText("Zapisano zmiany.");
					}
				}
			}
		});
	}

	public CategoryData getCategory() {
		return category;
	}

	public void setCategory(CategoryData category) {
		this.category = category;
	}

}
