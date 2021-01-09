package application;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.NumberStringConverter;

public class panierController implements Initializable{
	
	Popup popup;
	Popup popupQuantNull;
	Label message;
	@FXML 
	private TextField quantity_text;  
	@FXML
	private Button add;
	private Button supp;
	@FXML 
	private Button passerLaCom;
	@FXML 
	private Label lbl_sous_total;
	@FXML 
	private Label reduction;
	@FXML 
	private Label lbl_total;
	@FXML 
	private Text lbl_price;
	@FXML 
	private Label lbl_total_commande;
	@FXML 
	public void addArticle(ActionEvent event)
	{
		Integer quantite = Integer.valueOf(quantity_text.getText()); 
		Integer r = quantite + 1;
		Float prix = Float.valueOf(lbl_price.getText()); 
		Float total = r * prix;
		quantity_text.setText(r.toString());
		lbl_total.setText(total.toString());
		lbl_sous_total.setText(total.toString());
		//mise � jour de la r�duction quand il y a plus de 3 articles 
		if (r >=3 )
		{
			reduction.setText("15");
		}
		
		Integer reduc = Integer.valueOf(reduction.getText()); 
		if (reduc == 0) {
			Float totalAPayer = total;
			lbl_total_commande.setText(totalAPayer.toString());
		}
		else {
			Float totalAPayer = (float) (total * 0.85) ;
			lbl_total_commande.setText(totalAPayer.toString());
		}
	}
	public void deleteArticle (ActionEvent event) {
		Integer quantite = Integer.valueOf(quantity_text.getText()); 
		Integer r = quantite - 1;
		if (r >= 0) {
			quantity_text.setText(r.toString());
			
		}
	}
	public void handlePopup(ActionEvent event){ 
        if(popup.isShowing()){ 
            popup.hide(); 
            }else { 
                final Window window = passerLaCom.getScene().getWindow(); 
                popup.setWidth(50); 
                popup.setHeight(100); 
                final double x = window.getX() + passerLaCom.localToScene(0, 0).getX() + passerLaCom.getScene().getX() ; 
                final double y = window.getY() + passerLaCom.localToScene(0, 0).getY() + passerLaCom.getScene().getY() + passerLaCom.getHeight(); 
                popup.getContent().clear(); 
                popup.getContent().addAll(message); 
                popup.show(window, x, y);
                } 
        }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		popup = new Popup(); 
		message = new Label("Vous serez redig� vers le paiement ... "); 
		message.setTextFill(Color.BLUE);
		message.setPadding(new Insets(5,0,0,0));
	}     
	
}
