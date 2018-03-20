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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewController implements Initializable {

	CategoryDao categoryDao = new CategoryDao();

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private TextField nameCategoryTextField;

	@FXML
	private Button newCategoryButton;

	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setNewCategoryButtonClickEvent();
	}

	public void displayPane(boolean display) {
		mainAnchorPane.setVisible(display);
		mainAnchorPane.toFront();
	}

	private void setNewCategoryButtonClickEvent() {
		newCategoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (!nameCategoryTextField.getText().equals("")) {
					CategoryData category = new CategoryData(getFreeIndex(), nameCategoryTextField.getText());

					categoryDao.insertCategory(category);

					infoLabel.setText("Dodawanie kategori przebieg³o poprawnie");

				} else {
					infoLabel.setText("Wype³nij pole nazw¹.");
				}
			}
		});
	}

	private int getFreeIndex() {

		List<Integer> lista = categoryDao.getAllId();

		for (int i = 1; i < lista.size() + 1; i++) {

			if (i != lista.get(i - 1)) {

				return i;

			}
		}

		return lista.size() + 1;
	}
}
