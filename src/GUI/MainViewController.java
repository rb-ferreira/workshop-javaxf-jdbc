package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import GUI.util.Alerts;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuIntemSeller;
	
	@FXML
	private MenuItem menuIntemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuIntemSellerAction() {
		
		System.out.println("onMenuIntemSellerAction");
	}
	
	@FXML
	public void onMenuIntemDepartmentAction() {
		
		System.out.println("onMenuIntemDepartment");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		
		loadView("/GUI/About.fxml");
		
	}
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized void loadView(String AbsoluteName) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(AbsoluteName));
		VBox newVbox = loader.load();
		
		Scene mainScene = Main.getMainScene();
		VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
		
		Node mainMenu = mainVbox.getChildren().get(0);
		mainVbox.getChildren().clear();
		mainVbox.getChildren().add(mainMenu);
		mainVbox.getChildren().addAll(newVbox.getChildren());
		
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro Loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
