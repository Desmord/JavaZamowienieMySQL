package controllers.order;

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

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private CheckBox orderNumberCheckBox;

	@FXML
	private CheckBox customerIdCheckBox;

	@FXML
	private TextField searchTextField;

	@FXML
	private Button searchButton;

	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setSearchButtonClickEvent();
		
	}

	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);

	}

	private void setSearchButtonClickEvent() {
		
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				System.out.println("aksdhg");
				
			}
		});
		
	}
	
}
