package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Window;

public class ControllerArticle implements Initializable { 
	@FXML 
	Button panier; 
	Popup popup; 
	Label screen; 
	
	@Override 
	public void initialize(URL location, ResourceBundle resources) { 
		popup = new Popup(); 
		screen = new Label("Cet article a bien été ajouté à votre panier !"); 
		screen.setTextFill(Color.BLUE);
		screen.setPadding(new Insets(5,0,0,0));
		} 
	
	public void handlePopup(ActionEvent event){ 
		if(popup.isShowing()){ 
			popup.hide(); 
			}else { 
				final Window window = panier.getScene().getWindow(); 
				popup.setWidth(50); 
				popup.setHeight(100); 
				final double x = window.getX() + panier.localToScene(0, 0).getX() + panier.getScene().getX() ; 
				final double y = window.getY() + panier.localToScene(0, 0).getY() + panier.getScene().getY() + panier.getHeight(); 
				popup.getContent().clear(); 
				popup.getContent().addAll(screen); 
				popup.show(window, x, y);
				} 
		}

}

