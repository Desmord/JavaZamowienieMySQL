package controllers.category;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.order.TableViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class EditController implements Initializable {

	@FXML
	private AnchorPane mainAnchorPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("Inicjacja kontrolera edit z kategori");
	}

	public void displayPane(boolean display) {

		 mainAnchorPane.setVisible(display);
		 mainAnchorPane.toFront();
	}
}
