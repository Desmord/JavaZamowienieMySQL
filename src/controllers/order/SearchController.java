package controllers.order;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.OrderDao;
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

		setOrderNumberCheckBoxCheckEvent();
		setCustomerIdCheckBoxCheckEvent();
		setSearchButtonClickEvent();

	}

	public void displayPane(boolean display) {

		mainAnchorPane.setVisible(display);

	}

	private void setOrderNumberCheckBoxCheckEvent() {

		orderNumberCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				customerIdCheckBox.setSelected(false);

			}
		});

	}

	private void setCustomerIdCheckBoxCheckEvent() {

		customerIdCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				orderNumberCheckBox.setSelected(false);

			}
		});

	}

	private void setSearchButtonClickEvent() {

		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				infoLabel.setText("");
				
				if (isTextFieldEmpty()) {

					if (orderNumberCheckBox.isSelected()) {

						if (isNumber()) {

							System.out.println("id");

						}else {
							
							infoLabel.setText("Muszisz podaæ liczbê.");
							
						}

					} else if (customerIdCheckBox.isSelected()) {

						System.out.println("klient");

					} else {

						infoLabel.setText("Nie wybrano opcji wyszukiwania.");

					}

				} else {

					infoLabel.setText("Nie wpisano ¿adnej wartoœci w pole tekstowe.");

				}

			}
		});

	}

	private boolean isTextFieldEmpty() {

		if (searchTextField.getText().equals("")) {

			return false;

		}

		return true;
	}

	private boolean isNumber() {

		String text = searchTextField.getText();
		
		for(int i = 0;i<text.length();i++) {
		
			if(!text.substring(i,i+1).matches("[0-9]")) {
				return false;
			}
			
		}
		
		return true;
	}

}
